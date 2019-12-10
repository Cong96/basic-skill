package com.chaos.im.sdk.android;

public class AuthenticateTest {

    public static void main(String[] args) throws Exception {
        ImClient imClient = new ImClient();
        //SIT
        imClient.connect("61.14.255.57", 8091);
        //local
//        imClient.connect("127.0.0.1", 8080);
        imClient.authenticate("1194565607837249536", "token-002");

        while (true) {
            Thread.sleep(100);
            if (Monitor.INSTANCE.getFlag()) {
                imClient.sendMessage("1194565607837249536", "1194564166810980352", "i got you, i'm davis");
                Monitor.INSTANCE.setFlag(false);
            }
        }

    }

}
