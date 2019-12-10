package com.chaos.im.sdk.android;

/**
 * @Author: BryantCong
 * @Date: 2019/11/13 15:22
 * @Description:
 */
public enum Monitor {
    INSTANCE;
    public volatile boolean received = false;

    public boolean getFlag() {
        return received;
    }

    public void setFlag(boolean received) {
        this.received = received;
    }
}
