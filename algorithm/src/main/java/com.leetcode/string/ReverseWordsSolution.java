package com.leetcode.string;

/**
 * @ClassName ReverseWordsSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/2/1 21:13
 * @Version V1.0
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class ReverseWordsSolution {

    public static void main(String[] args) {
        String str = " hello world!  ";
        System.out.println(str.trim());
    }

    //TODO
    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        s = s.trim(); // delete leading or trailing spaces.
        int i = s.length() - 1, j = s.length();
        while (i > 0) {
            if (s.charAt(i) == ' ') {
                res.append(s.substring(i + 1, j));
                res.append(' ');
                while (s.charAt(i) == ' ') i--; // ignore extra spaces between words.
                j = i + 1;
            }
            i--;
        }
        return res.append(s.substring(0, j)).toString();
    }


}
