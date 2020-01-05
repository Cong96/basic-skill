package com.leetcode.thread;

import java.util.concurrent.Semaphore;

/**
 * @Author: BryantCong
 * @Date: 2020/1/5 16:29
 * @Description: 现在有两种线程，氢 oxygen 和氧 hydrogen，你的目标是组织这两种线程来产生水分子。
 * <p>
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 * <p>
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 * <p>
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 * <p>
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 * <p>
 * 换句话说:
 * <p>
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "HOH"
 * 输出: "HHO"
 * 解释: "HOH" 和 "OHH" 依然都是有效解。
 * 示例 2:
 * <p>
 * 输入: "OOHHHH"
 * 输出: "HHOHHO"
 * 解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OHHOHH" 依然都是有效解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/building-h2o
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 似乎都可以使用信号量来解决
 */
public class H2O {

    public H2O() {

    }

    private Semaphore s1 = new Semaphore(2);
    private Semaphore s2 = new Semaphore(1);
    private Semaphore hSemaphore = new Semaphore(0);
    private Semaphore oSempphore = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        s1.acquire(1);
        hSemaphore.release(1);
        oSempphore.acquire(2);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        s1.release(1);//通知被阻塞的H元素可以进来了
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        s2.acquire(1);
        oSempphore.release(2);
        hSemaphore.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        s2.release(1);
    }
}
