package com.wangcc.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: BryantCong
 * @Date: 2019/10/29 16:58
 * @Description:
 */
public class BallonSolution {
    public static void main(String[] args) {

    }

    class myComparator implements Comparator<Bollon> {
        public int compare(Bollon a, Bollon b) {
            if (a.end == a.end) {
                return a.start - b.start;
            }

            return a.end - b.end;
        }
    }

    class Bollon {
        int start;
        int end;
    }


    public int minArrowNums(Bollon[] bollons) {
        if (bollons == null || bollons.length == 0) {
            return 0;
        }
        Arrays.sort(bollons, new myComparator());
        int end = bollons[0].end;
        int count = 1;
        for (int i = 1; i < bollons.length; i++) {
            if (bollons[i].start > end) {
                count++;
                end = bollons[i].end;
            }
        }
        return count;
    }
}
