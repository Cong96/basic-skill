package com.datastructure.sort;

/**
 * @Author: BryantCong
 * @Date: 2019/12/10 18:00
 * @Description: 快速排序   JDK中对于数组类型的排序也是使用的快速排序，但是是优化过的快排，有空可以深入源码分析
 * <p>
 * 快排的核心，每一次让基准元素归位
 */
public class QuickSort {


    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        //最后是两个相邻的元素进行排序
        if (left < right) {
            int pos = pos(arr, left, right);
            //那如果刚好pos就是0呢？那也没关系，此时不满足left<right的关系
            //两个相邻元素，也不会符合left<right关系，所以也不会影响，一定要注意left<right的关键性
            quickSort(arr, left, pos - 1);
            quickSort(arr, pos + 1, right);
        }
    }

    private int pos(int[] arr, int left, int right) {
        //以原left位置上的元素作为基础
        int temp = arr[left];
        while (left < right) {
            //从后往前遍历，找到第一个小于当前基准元素的值，把他放入到最前端（即最左边）
            //为什么里面也要加上lef<right的判断呢？
            //因为要考虑刚好一切都是有序的情况，会导致遍历下来全都是符合条件的元素
            //这个时候，就需要利用该条件，退出整个循环了
            while (left < right && temp <= arr[right]) {
                right--;
            }
            //一旦找到第一个小于基准值的元素，放入到最前端
            arr[left] = arr[right];
            //找到左侧比他大的元素，把他放入到右侧
            while (left < right && temp >= arr[left]) {
                left++;
            }

            arr[right] = arr[left];
        }
        //这样一趟下来，虽然不能保证各个位置都是有顺序的，但是至少确保了一点，
        //基准元素找到了他应有的位置，在他左边的都比他小（尽管此时比他小的并不是有序的）
        //在他右边的元素都比他大（尽管不是有序的）
        arr[left] = temp;
        return left;
    }
}
