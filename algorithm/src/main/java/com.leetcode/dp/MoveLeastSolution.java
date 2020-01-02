package com.leetcode.dp;

import java.util.*;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 10:46
 * @Description:
 */
public class MoveLeastSolution {

    public static void main(String[] args) {
        int[] moves = new int[]{3, 1, 2, 1, 3, 1};
        MoveLeastSolution moveLeastSolution = new MoveLeastSolution();
        System.out.println(moveLeastSolution.moveLeast(moves));
        List<Integer> track = moveLeastSolution.moveTrack(moves);
        for (Integer i : track) {
            System.out.println(i);
        }
    }

    public int moveLeast(int[] moves) {
        int dp[] = new int[moves.length];
        Arrays.fill(dp, moves.length);
        dp[0] = 0;
        for (int right = 1; right < moves.length; right++) {
            for (int left = 0; left < right; left++) {
                if (moves[left] + left >= right) {
                    if (dp[left] + 1 < dp[right]) {
                        dp[right] = dp[left] + 1;
                    }
                }
            }
        }

        return dp[moves.length - 1];
    }

    public List<Integer> moveTrack(int[] moves) {
        int dp[] = new int[moves.length];
        Arrays.fill(dp, moves.length);
        Map<Integer, Integer> trackMap = new HashMap<>();
        dp[0] = 0;
        for (int right = 1; right < moves.length; right++) {
            int max = -1;
            for (int left = 0; left < right; left++) {
                if (moves[left] + left >= right) {
                    if (dp[left] + 1 < dp[right]) {
                        dp[right] = dp[left] + 1;
                        max = left;
                    }
                }
            }
            if (max != -1) {

                trackMap.put(right, max);
            }
        }
        LinkedList<Integer> stack = new LinkedList<>();
        Integer max = moves.length - 1;
        stack.addFirst(moves[max]);

        while (max > 0) {
            max = trackMap.get(max);
            stack.addFirst(moves[max]);

        }
        return stack;
    }
}
