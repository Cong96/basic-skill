package com.wangcc.algorithm.dp;

/**
 * @Author: BryantCong
 * @Date: 2019/10/28 15:24
 * @Description:
 */
public class RemoveRepeatSloution {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 3, 4,4, 4};
        int size = removeRepeat(arr);
        System.out.println(size);
//        for(int i:arr){
//            System.out.println(i);
//        }
    }

    public static int removeRepeat(int[] arr) {
        int number = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[number]) {
                number++;
                arr[number] = arr[i];
            }
        }
        return number + 1;
    }
}
