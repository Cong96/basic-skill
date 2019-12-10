package com.wangcc.algorithm.dp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: BryantCong
 * @Date: 2019/10/26 11:49
 * @Description:
 */
public class OddEvenPrinterByLock {
    private final int limit;
    private int count;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public OddEvenPrinterByLock(int limit, int initCount) {
        this.limit = limit;
        this.count = initCount;
    }

    public void print() {
        while (count <= limit) {

        }
    }

}
