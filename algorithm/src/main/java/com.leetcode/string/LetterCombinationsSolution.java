package com.leetcode.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LetterCombinationsSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/2/1 16:22
 * @Version V1.0
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LetterCombinationsSolution {

    public static void main(String[] args) {

    }

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    //TODO  回溯
    public List<String> letterCombinations(String digits) {
        Map<Character, String> telMap = new HashMap<>();
        telMap.put('2', "abc");
        telMap.put('3', "def");

        int length = digits.length();

        return null;
    }

    public void trackback(int length) {
        for (int i = 0; i < length; i++) {

        }
    }
}
