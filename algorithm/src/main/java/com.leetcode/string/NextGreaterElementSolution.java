package com.leetcode.string;

/**
 * @ClassName NextGreaterElementSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/2/1 21:16
 * @Version V1.0
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12
 * 输出: 21
 * 示例 2:
 * <p>
 * 输入: 21
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class NextGreaterElementSolution {
    //TODO 一道数学以及排序相关的题目
    public static void main(String[] args) {
        int n = 1999999999;
        NextGreaterElementSolution nextGreaterElementSolution = new NextGreaterElementSolution();
        System.out.println(nextGreaterElementSolution.nextGreaterElement(n));
    }

    public int nextGreaterElement(int n) {
        char[] arr = ("" + n).toCharArray();
        int i = arr.length - 1;
        //如果从右到左一直是升序，那么不会有更大的值出现
        while (i >= 1 && arr[i] <= arr[i - 1]) {
            i--;
        }
        if (i == 0) {
            return -1;
        }
        int j = arr.length - 1;
        //如果不是一直升序，而是在某个点发生了降序，那么我们需要从右到左找到第一个大于这个值下标
        while (j >= 0 && arr[j] <= arr[i - 1]) {
            j--;
        }
        //找到下标j
        swap(arr, i - 1, j);
        reverse(arr, i);
        try {
            return Integer.parseInt(new String(arr));

        } catch (Exception e) {
            return -1;
        }

    }

    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
