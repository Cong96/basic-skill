package com.leetcode.sort;

/**
 * @ClassName SortColorSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/23 14:26
 * @Version V1.0
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 需要一趟遍历解决
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 荷兰国旗问题
 **/
public class SortColorSolution {


    public static void main(String[] args) {

    }
    public void sortColors(int[] nums) {
        int length=nums.length;
        int index0=0;
        int index2=length-1;
        int curr=0;
        while(curr<=index2){
            if(nums[curr]==0){
                swap(nums,curr,index0);
                index0++;
                curr++;
            }
            else if(nums[curr]==1){
                curr++;
            }
            else{
                swap(nums,curr,index2);
                index2--;
            }
        }
    }

    private void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
