package com.ali.prepare.dp;

import java.util.*;

/**
 * @Author: BryantCong
 * @Date: 2020/1/4 18:26
 * @Description:
 */
public class MoveLeastSolution {
    public static void main(String[] args) {
        int[] moves = new int[]{3, 1, 2, 1, 3, 1};
        MoveLeastSolution moveLeastSolution = new MoveLeastSolution();
        System.out.println(moveLeastSolution.leastMove(moves));
        List<Integer> track = moveLeastSolution.moveTrack(moves);
        for (Integer i : track) {
            System.out.println(i);
        }
    }

    public int leastMove(int[] moves) {
        if (moves == null) {
            return -1;
        }
        if (moves.length <= 1) {
            return 0;
        }
        int[] dp = new int[moves.length];
        //如果存在0，最好在这里使用moves长度fill一下，然后判断是否可达
        dp[0] = 0;
        for (int right = 1; right < moves.length; right++) {
            dp[right] = right;
            for (int left = 0; left < right; left++) {
                if (moves[left] + left >= right && dp[right] > dp[left] + 1) {
                    dp[right] = dp[left] + 1;
                }
            }
        }
        return dp[moves.length - 1];
    }

    public List<Integer> moveTrack(int[] moves) {
        LinkedList<Integer> res = new LinkedList<>();
        if (moves == null) {
            return res;
        }
        if (moves.length <= 1) {
            return res;
        }
        int[] dp = new int[moves.length];
        Arrays.fill(dp, moves.length);
        dp[0] = 0;
        Map<Integer, Integer> trackMap = new HashMap<>();
        for (int right = 1; right < moves.length; right++) {
            int minStepIndex = -1;
            for (int left = 0; left < right; left++) {
                if (moves[left] + left >= right && dp[left] + 1 < dp[right]) {
                    dp[right] = dp[left] + 1;
                    minStepIndex = left;
                }
            }
            trackMap.put(right, minStepIndex);
        }
        int track = moves.length - 1;
        res.addFirst(moves[track]);
        while (track > 0) {
            track = trackMap.get(track);
            res.addFirst(moves[track]);
        }
        return res;
    }
}
