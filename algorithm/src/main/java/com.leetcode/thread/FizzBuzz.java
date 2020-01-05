package com.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Author: BryantCong
 * @Date: 2020/1/5 16:06
 * @Description: 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 留下来鞭尸的代码
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
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizzSemaphore.acquire(1);
                printFizz.run();
                numberSemaphore.release(1);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                buzzSemaphore.acquire(1);
                printBuzz.run();
                numberSemaphore.release(1);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzzSemaphore.acquire(1);
                printFizzBuzz.run();
                numberSemaphore.release(1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                numberSemaphore.acquire(1);
                fizzbuzzSemaphore.release(1);
            } else if (i % 3 == 0 && i % 5 != 0) {
                numberSemaphore.acquire(1);
                fizzSemaphore.release(1);
            } else if (i % 3 != 0 && i % 5 == 0) {
                numberSemaphore.acquire(1);
                buzzSemaphore.release(1);
            } else {
                numberSemaphore.acquire(1);
                printNumber.accept(i);
                numberSemaphore.release(1);
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
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzBuzz,"));
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
