package com.chaos.im.sdk.android;

import com.chaos.im.common.Constants;
import com.chaos.im.common.Message;
import com.chaos.im.common.Request;
import com.chaos.im.common.Response;
import com.chaos.im.protocol.AuthenticateResponseProto;
import com.chaos.im.protocol.MessagePushRequestProto;
import com.chaos.im.protocol.MessagePushResponseProto;
import com.chaos.im.protocol.MessageSendResponseProto;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;

public class ImClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SocketChannel gatewayInstance = (SocketChannel) ctx.channel();

        Message message = new Message((ByteBuf) msg);

        System.out.println("收到TCP接入系统发过来的消息，消息类型为：" + message.getMessageType());

        if (message.getMessageType() == Constants.MESSAGE_TYPE_RESPONSE) {

            Response response = message.toResponse();

            if (response.getRequestType() == Constants.REQUEST_TYPE_AUTHENTICATE) {
                AuthenticateResponseProto.AuthenticateResponse authenticateResponse = AuthenticateResponseProto.AuthenticateResponse
                        .parseFrom(response.getBody());
                //TODO 处理认证
                System.out.println("认证请求收到响应：" + authenticateResponse);
            } else if (response.getRequestType() == Constants.REQUEST_TYPE_SEND_MESSAGE) {
                MessageSendResponseProto.MessageSendResponse messageSendResponse = MessageSendResponseProto.MessageSendResponse
                        .parseFrom(response.getBody());
                //TODO 消息已经成功入库了，客户端可以将消息置为成功发送
                System.out.println("客户端收到单聊入库响应的信息：" + messageSendResponse);
            }
        } else if (message.getMessageType() == Constants.MESSAGE_TYPE_REQUEST) {
            Request request = message.toRequest();

            if (request.getRequestType() == Constants.REQUEST_TYPE_PUSH_MESSAGE) {
                MessagePushRequestProto.MessagePushRequest messagePushRequest = MessagePushRequestProto.MessagePushRequest
                        .parseFrom(request.getBody());
                //TODO 处理消息
                System.out.println("接收到一条消息推送：" + messagePushRequest);

                MessagePushResponseProto.MessagePushResponse.Builder builder = MessagePushResponseProto.MessagePushResponse
                        .newBuilder();
                builder.setMessageId(messagePushRequest.getMessageId());
                MessagePushResponseProto.MessagePushResponse messagePushResponse = builder.build();

                Response response = new Response(request, messagePushResponse.toByteArray());

                gatewayInstance.writeAndFlush(response.getBuffer());

                System.out.println("返回消息推送的响应给接入系统：" + messagePushResponse);
                Monitor.INSTANCE.setFlag(true);
            } else if (Constants.REQUEST_TYPE_PUSH_GROUP_MESSAGE == request.getRequestType()) {
                //TODO 群聊消息
                MessagePushRequestProto.MessagePushRequest messagePushRequest = MessagePushRequestProto.MessagePushRequest
                        .parseFrom(request.getBody());
                //TODO 处理消息
                String groupId = messagePushRequest.getGroupId();
                System.out.println("接收到一条群聊消息推送：" + messagePushRequest);

                MessagePushResponseProto.MessagePushResponse.Builder builder = MessagePushResponseProto.MessagePushResponse
                        .newBuilder();
                builder.setMessageId(messagePushRequest.getMessageId());
                MessagePushResponseProto.MessagePushResponse messagePushResponse = builder.build();

                Response response = new Response(request, messagePushResponse.toByteArray());

                gatewayInstance.writeAndFlush(response.getBuffer());
                System.out.println("返回消息推送的响应给接入系统：" + messagePushResponse);
                Monitor.INSTANCE.setFlag(true);

            }
        }
    }

}
