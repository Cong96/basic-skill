package com.leetcode.thread.refactor;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Author: BryantCong
 * @Date: 2020/1/5 16:34
 * @Description: 信号量确实好用，但是也要知道其他的解决方案
 */
public class FizzBuzz {
    private int n;

    private Semaphore numberSemaphore = new Semaphore(1);
    private Semaphore fizzbuzzSemaphore = new Semaphore(0);
    private Semaphore fizzSemaphore = new Semaphore(0);
    private Semaphore buzzSemaphore = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 3) {
            if (i % 5 == 0) {
                continue;
            }
            fizzSemaphore.acquire(1);
            printFizz.run();
            numberSemaphore.release(1);
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 5) {
            if (i % 3 == 0) {
                continue;
            }
            buzzSemaphore.acquire(1);
            printBuzz.run();
            numberSemaphore.release(1);
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 15) {
            fizzbuzzSemaphore.acquire(1);
            printFizzBuzz.run();
            numberSemaphore.release(1);

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            //先拿走一个许可，否则，通知不到你了
            numberSemaphore.acquire(1);
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                numberSemaphore.release(1);
            } else if (i % 5 != 0) {
                fizzSemaphore.release(1);
            } else if (i % 3 != 0) {
                buzzSemaphore.release(1);
            } else {
                fizzbuzzSemaphore.release(1);
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread numberThread = new Thread(() -> {
            try {
                fizzBuzz.number(i -> System.out.print(i + ","));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread fizzThread = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz,"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread buzzThread = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz,"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread fizzBuzzThread = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzBuzz。"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        fizzBuzzThread.start();
        fizzThread.start();
        buzzThread.start();
        numberThread.start();
    }

}
