package com.leetcode.string;

import java.util.Stack;

/**
 * @ClassName SmallestSubsequenceSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/2/1 21:19
 * @Version V1.0
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："cdadabcc"
 * 输出："adbc"
 * 示例 2：
 * <p>
 * 输入："abcd"
 * 输出："abcd"
 * 示例 3：
 * <p>
 * 输入："ecbacba"
 * 输出："eacb"
 * 示例 4：
 * <p>
 * 输入："leetcode"
 * 输出："letcod"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 1000
 * text 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 贪心和动态规划一样，考验的是对问题分析的能力，
 * 贪心算法解题的关键在于如何找到每次的局部最优解，动态规划则是如何找到状态转移方程。
 **/
public class SmallestSubsequenceSolution {

    public static void main(String[] args) {
        char c2 = 'a' + 1;
        System.out.println(c2);
    }

    public String smallestSubsequence(String text) {
        //贪心算法
        //一个题能不能用贪心思想来解决取决于它能不能通过局部最优得到全局最优。
        //TODO
        //那如果那些字典序靠前的字符出现得比较晚该怎么办呢？此时就要看 ，如果将来有可能出现，就把前面的字符依次删去，经过这样的流程，得到的子序列就符合题意，这是 贪心算法 的思想，局部最优则全局最优。
        //
        //作者：liweiwei1419
        //链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/solution/tan-xin-suan-fa-zhan-wei-yan-ma-python-dai-ma-java/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        int len = text.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            Character c = text.charAt(i);
            //
            if (stack.contains(c)) {
                continue;
            }
            //返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
            while (!stack.empty() && c < stack.peek() && text.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();


    }


}
