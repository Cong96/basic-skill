package com.wangcc.algorithm.leetcode;

/**
 * @Author: BryantCong
 * @Date: 2019/10/30 11:09
 * @Description:
 */
public class PeachSolution {

    public static void main(String[] args) {
        int[] peaches = new int[]{2, 6, 1, 8, 7, 11, 9};
        PeachSolution solution = new PeachSolution();
        System.out.println(solution.pick(peaches));
    }

    public int pick(int[] peaches) {
        int[] numbers = new int[peaches.length];
        numbers[0] = 1;
        for (int i = 1; i < peaches.length; i++) {
            numbers[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (peaches[j] <= peaches[i] && numbers[j] + 1 > numbers[i]) {
                    numbers[i] = numbers[j] + 1;
                }
            }
        }
        int max = 0;
        for (int number : numbers) {
            max = number > max ? number : max;
        }

        return max;
    }
}
