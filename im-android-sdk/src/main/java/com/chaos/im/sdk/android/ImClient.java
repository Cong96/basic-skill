package com.chaos.im.sdk.android;

import com.chaos.im.common.Constants;
import com.chaos.im.common.Request;
import com.chaos.im.protocol.AuthenticateRequestProto;
import com.chaos.im.protocol.MessageSendRequestProto;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

import java.util.Objects;


public class ImClient {

    private EventLoopGroup threadGroup;

    private Bootstrap client;

    private SocketChannel socketChannel;

    /**
     * 建立连接
     *
     * @param host
     * @param port
     * @throws Exception
     */
    public void connect(String host, int port) throws Exception {
        this.threadGroup = new NioEventLoopGroup();
        this.client = new Bootstrap();

        client.group(threadGroup).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_KEEPALIVE, true).handler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
                ch.pipeline().addLast(new DelimiterBasedFrameDecoder(4096, delimiter));
                ch.pipeline().addLast(new ImClientHandler());
            }
        });

        final ChannelFuture channelFuture = client.connect(host, port);
        System.out.println("发起对TCP接入系统的连接");
        while (!channelFuture.isDone()) {
            Thread.yield();
        }
        if (channelFuture.isSuccess()) {
            socketChannel = (SocketChannel) channelFuture.channel();
            System.out.println("已经跟TCP接入系统建立连接，TCP接入系统地址为：" + socketChannel);
        } else {
            close();
        }
//        channelFuture.addListener(new ChannelFutureListener() {
//            public void operationComplete(ChannelFuture future) throws Exception {
//                if (channelFuture.isSuccess()) {
//                    socketChannel = (SocketChannel) channelFuture.channel();
//                    System.out.println("已经跟TCP接入系统建立连接，TCP接入系统地址为：" + socketChannel);
//                } else {
//                    close();
//                }
//            }
//        });
    }

    /**
     * 发起token认证
     *
     * @param uid
     * @param token
     * @throws Exception
     */
    public void authenticate(String uid, String token) throws Exception {
        // 封装认证请求的消息体
        AuthenticateRequestProto.AuthenticateRequest.Builder builder = AuthenticateRequestProto.AuthenticateRequest
                .newBuilder();
        builder.setUid(uid);
        builder.setToken(token);
        builder.setTimestamp(System.currentTimeMillis());
        AuthenticateRequestProto.AuthenticateRequest authenticateRequest = builder.build();

        // 封装一个完整的请求消息
        Request request = new Request(Constants.APP_SDK_VERSION_1, Constants.REQUEST_TYPE_AUTHENTICATE,
                Constants.SEQUENCE_DEFAULT, authenticateRequest.toByteArray());

        // 将认证请求发送给TCP接入系统
        socketChannel.writeAndFlush(request.getBuffer());
    }

    public void close() throws Exception {
        if (Objects.nonNull(socketChannel)) {
            this.socketChannel.close();
        }
        this.threadGroup.shutdownGracefully();
    }

    /**
     * 发送单聊消息
     *
     * @param senderId
     * @param receiverId
     * @param content
     */
    public void sendMessage(String senderId, String receiverId, String content) {

        //TODO 发送消息是否需要客户端指定递增的序列号 以便客户端明确哪条消息已经发送成功

        MessageSendRequestProto.MessageSendRequest messageSendRequest = getMessageSendRequest(senderId, receiverId, content);

        Request request = new Request(Constants.APP_SDK_VERSION_1, Constants.REQUEST_TYPE_SEND_MESSAGE,
                Constants.SEQUENCE_DEFAULT, messageSendRequest.toByteArray());

        System.out.println("客户端向接入系统发送一条单聊消息，" + messageSendRequest);

        socketChannel.writeAndFlush(request.getBuffer());
    }

    private MessageSendRequestProto.MessageSendRequest getMessageSendRequest(String senderId, String receiverId, String content) {
        MessageSendRequestProto.MessageSendRequest.Builder builder = MessageSendRequestProto.MessageSendRequest
                .newBuilder();
        builder.setSenderId(senderId);
        builder.setReceiverId(receiverId);
        builder.setContent(content);
        return builder.build();
    }

    public void sendGroupMessage(String senderId, String groupId, String content) {
        MessageSendRequestProto.MessageSendRequest messageSendRequest = getMessageSendRequest(senderId, groupId, content);

        Request request = new Request(Constants.APP_SDK_VERSION_1, Constants.REQUEST_TYPE_SEND_GROUP_MESSAGE,
                Constants.SEQUENCE_DEFAULT, messageSendRequest.toByteArray());

        System.out.println("客户端向接入系统发送一条群聊消息，" + messageSendRequest);

        socketChannel.writeAndFlush(request.getBuffer());

    }

}
