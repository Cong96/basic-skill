package com.leetcode.string;

/**
 * @ClassName AlphabetBoardPathSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/2/1 15:38
 * @Version V1.0
 * <p>
 * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
 * <p>
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"].
 * <p>
 * 我们可以按下面的指令规则行动：
 * <p>
 * 如果方格存在，'U' 意味着将我们的位置上移一行；
 * 如果方格存在，'D' 意味着将我们的位置下移一行；
 * 如果方格存在，'L' 意味着将我们的位置左移一列；
 * 如果方格存在，'R' 意味着将我们的位置右移一列；
 * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
 * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/alphabet-board-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * 示例 2：
 * <p>
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= target.length <= 100
 * target 仅含有小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/alphabet-board-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class AlphabetBoardPathSolution {
    public String alphabetBoardPath(String target) {
        char[][] board = new char[6][5];
        board[0] = "abcde".toCharArray();
        board[1] = "fghij".toCharArray();
        board[2] = "klmno".toCharArray();
        board[3] = "pqrst".toCharArray();
        board[4] = "uvwxy".toCharArray();
        board[5] = "z".toCharArray();
        int length = target.length();
        StringBuilder sb = new StringBuilder();
        int lastRow = 0;
        int lastClo = 0;
        for (int i = 0; i < length; i++) {
            int currChar = target.charAt(i);
            int curRow = (currChar - 'a') / 5;
            int currClo = (currChar - 'a') % 5;
            //必须先行后列
            handleRow(sb, curRow, lastRow);
            handleRow(sb, currClo, lastClo);


        }
        return sb.toString();
    }


    private int handleRow(StringBuilder sb, int row, int lastRow) {
        int move = row - lastRow;
        if (move == 0) {
            return row;
        }
        String order;
        if (move > 0) {
            order = "D";
        } else {
            order = "U";
        }
        int absMove = Math.abs(move);
        while (absMove > 0) {
            absMove -= 1;
            sb.append(order);
        }
        return row;
    }

    private int handleClo(StringBuilder sb, int clo, int lastClo) {
        int move = clo - lastClo;
        if (move == 0) {
            return clo;
        }
        String order;
        if (move > 0) {
            order = "R";
        } else {
            order = "L";
        }
        int absMove = Math.abs(move);
        while (absMove > 0) {
            absMove -= 1;
            sb.append(order);
        }
        return clo;

    }
}
