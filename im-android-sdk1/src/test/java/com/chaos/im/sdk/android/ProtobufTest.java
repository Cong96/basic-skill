package com.chaos.im.sdk.android;

import com.chaos.im.protocol.AuthenticateRequestProto;

public class ProtobufTest {

	public static void main(String[] args) throws Exception {
		AuthenticateRequestProto.AuthenticateRequest authenticateRequest = createAuthenticateRequest();

		byte[] byteArray = authenticateRequest.toByteArray();

		AuthenticateRequestProto.AuthenticateRequest request = AuthenticateRequestProto.AuthenticateRequest
				.parseFrom(byteArray);
		System.out.println(request);
	}

	private static AuthenticateRequestProto.AuthenticateRequest createAuthenticateRequest() {
		AuthenticateRequestProto.AuthenticateRequest.Builder builder = AuthenticateRequestProto.AuthenticateRequest
				.newBuilder();
		builder.setUid("uid");
		builder.setToken("token");
		builder.setTimestamp(System.currentTimeMillis());
		return builder.build();
	}

}
