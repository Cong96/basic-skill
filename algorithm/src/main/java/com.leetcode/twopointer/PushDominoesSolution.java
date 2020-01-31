package com.leetcode.twopointer;

/**
 * @ClassName PushDominoesSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/31 14:41
 * @Version V1.0
 * 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
 * <p>
 * 在开始时，我们同时把一些多米诺骨牌向左或向右推。
 * <p>
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
 * <p>
 * 同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 * <p>
 * 如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。
 * <p>
 * 就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。
 * <p>
 * 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
 * <p>
 * 返回表示最终状态的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 * 示例 2：
 * <p>
 * 输入："RR.L"
 * 输出："RR.L"
 * 说明：第一张多米诺骨牌没有给第二张施加额外的力。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/push-dominoes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class PushDominoesSolution {
    public String pushDominoes(String dominoes) {
        //TODO
        return null;
    }
}
