package com.wangcc.algorithm.dp;

import java.util.concurrent.Semaphore;

/**
 * @Author: BryantCong
 * @Date: 2019/10/26 15:32
 * @Description:
 */
public class MutilThreadTest {
    static int result = 0;
    private int count = 0;
    private int limit;
    private int total;
    public final Semaphore[] semaphores;

    MutilThreadTest(int limit, int count, int total) throws InterruptedException {
        this.limit = limit;
        this.count = count;
        this.total = total;
        this.semaphores = new Semaphore[total];
        for (int i = 0; i < total; i++) {
            this.semaphores[i] = new Semaphore(1);
            if (i != total - 1) {
                this.semaphores[i].acquire();
            }
        }
    }

    public void print( int threadNo) {
        final Semaphore lastSemphore = threadNo == 0 ? semaphores[total - 1] : semaphores[threadNo - 1];
        final Semaphore curSemphore = semaphores[threadNo];
        final int index = threadNo;
        try {
            while (true) {
                lastSemphore.acquire();
                System.out.println(Thread.currentThread().getName() + ": " + count++);
                if (count > limit) {
                    break;
                }
                curSemphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {


        int n = 10;
        MutilThreadTest mutilThreadTest = new MutilThreadTest(100, 0, n);
        for(int i=0;i<n;i++){
            int finalI = i;
            new Thread(() -> mutilThreadTest.print(finalI) ,"thread"+finalI).start();
        }
//        //生成一组信号量
//        for (int i = 0; i < n; i++) {
//            semaphores[i] = new Semaphore(1);
//            if (i != n - 1) {
//                semaphores[i].acquire();
//            }
//        }


//        for (int i = 0; i < n; i++) {
//            final Semaphore lastSemphore = i == 0 ? semaphores[n - 1] : semaphores[i - 1];
//            final Semaphore curSemphore = semaphores[i];
//            final int index = i;
//            //把代码变得优雅一点
//            threads[i] = new Thread(() -> {
//                try {
//                    while (true) {
//                        lastSemphore.acquire();
//                        System.out.println("thread" + index + ": " + result++);
//                        if (result > 100) {
//                            break;
//                        }
//                        curSemphore.release();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            });
//            threads[i].start();
//        }
    }

}
