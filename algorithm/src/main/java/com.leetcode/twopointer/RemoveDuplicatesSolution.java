package com.leetcode.twopointer;

/**
 * @ClassName RemoveDuplicatesSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/29 16:27
 * @Version V1.0
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class RemoveDuplicatesSolution {

    public static void main(String[] args) {
        RemoveDuplicatesSolution removeDuplicatesSolution = new RemoveDuplicatesSolution();
        int[] arr = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicatesSolution.removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        int count = 1;
        int length = nums.length;
        int i = 1;
        while (i < length) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > 2) {
                moveArray(nums, i, length);
                //当我们合并两个重复元素，即缩减数组长度时，我们需要操作的原数组的下个元素，实际上就是新数组的当前index
                length--;
                i--;
            }
            i++;
        }

        return length;
    }

    public void moveArray(int[] nums, int index, int length) {

        for (int i = index; i < length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }
}
