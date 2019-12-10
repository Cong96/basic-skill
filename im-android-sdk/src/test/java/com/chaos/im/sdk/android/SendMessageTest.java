package com.chaos.im.sdk.android;

public class SendMessageTest {

	public static void main(String[] args) throws Exception{
		ImClient imClient = new ImClient();
		imClient.connect("127.0.0.1", 8080);
		imClient.authenticate("test001", "test001_token");
		imClient.sendMessage("test001", "test002", "hello world 123");

		while(true) {
			Thread.sleep(1000);
		}
	}

}
