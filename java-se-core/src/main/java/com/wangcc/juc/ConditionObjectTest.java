package com.wangcc.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: BryantCong
 * @Date: 2019/9/24 16:00
 * @Description:
 */
public class ConditionObjectTest {
    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition cond = lock.newCondition();

        int loop = 100;
        for (int i = 0; i < loop; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    count++;
                    cond.await();
                } catch (InterruptedException ignore) {
                } finally {
                    lock.unlock();
                    count--;
                }
            }, "succ-" + i).start();

            new Thread(() -> {
                boolean illegalMonitor = false;
                try {
                    cond.awaitUninterruptibly();
                } catch (IllegalMonitorStateException ignore) {
                    illegalMonitor = true;
                } finally {
                    assert illegalMonitor;
                }
            }, "fail-" + i).start();

        }

        while (count != loop) {
            Thread.yield();
        }

        while (count > 0) {
            lock.lock();
            try {
                cond.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
