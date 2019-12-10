package com.chaos.im.sdk.android;

public class AuthenticateTest {

    public static void main(String[] args) throws Exception {
        ImClient imClient = new ImClient();

        imClient.connect("127.0.0.1", 8080);
        imClient.authenticate("1194565093482811392", "token-002");

        while (true) {
            Thread.sleep(100);
            if (Monitor.INSTANCE.getFlag()) {
                imClient.sendGroupMessage("1194565093482811392", "1194582176058511360", "i got you, i'm james");
                Monitor.INSTANCE.setFlag(false);
            }
        }

    }

}
