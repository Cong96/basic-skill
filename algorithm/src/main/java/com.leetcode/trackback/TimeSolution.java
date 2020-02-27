package com.leetcode.trackback;

import java.util.*;

/**
 * @Author: BryantCong
 * @Date: 2020/1/2 13:55
 * @Description: 随机给出6个0~9的数字，按照24小时格式组合这六个数字，生成最早时间和最晚时间，如果不能生成则返回错误。如给定1、2、3、4、5、6六个数字，则组合生成的最早时间是：12:34:56，最晚时间是：23:56:41。如果给定111111六个数字，则能够组合生成的最早和最晚时间均是：11:11:11；如果给出的是999999六个数字，因为无法组合成24小时格式的时间则返回错误。
 */
public class TimeSolution {
    public static void main(String[] args) {


        TimeSolution timeSolution = new TimeSolution();
        int[] nums = new int[]{2, 2, 3, 0, 5, 7};
        //更好的肯定是使用对象接收，这里是偷懒，是非常不好的行为
        Map<String, String> timeResult = timeSolution.timeSolution(nums);
        if (!timeResult.isEmpty()) {
            System.out.println(timeResult.get("maxTime"));
            System.out.println(timeResult.get("minTime"));

        }
    }

    public Map<String, String> timeSolution(int[] nums) {
        if (nums == null || nums.length < 6) {
            //抛出异常
            return null;
        }
        Map<String, String> result = new HashMap<>();
        if (result.size() == 0) {
            //抛出异常
        }
        boolean[] used = new boolean[nums.length];
        timeSolution(nums, used, new Stack<>(), result);
        return result;
    }

    public void timeSolution(int[] nums, boolean[] used, Stack<Integer> track, Map<String, String> result) {
        if (track.size() == 6) {
            List<String> resultStr = new ArrayList<>();
            int i = 0;
            while (i < 6) {
                resultStr.add(track.get(i++) + "" + track.get(i++));
            }
            String currentStr = String.join(":", resultStr);
            String maxTime = result.getOrDefault("maxTime", currentStr);
            if (currentStr.compareTo(maxTime) >= 0) {
                result.put("maxTime", currentStr);
            }
            String minTime = result.getOrDefault("minTime", currentStr);
            if (currentStr.compareTo(minTime) <= 0) {
                result.put("minTime", currentStr);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (nums[i] < 0) {
                break;
            }
            if (track.size() % 2 == 0) {
                if (track.size() == 0) {
                    if (nums[i] > 2) {
                        continue;
                    }
                } else if (nums[i] > 5) {
                    continue;
                }
            } else {
                if (track.size() == 1) {
                    if (nums[i] > 3) {
                        continue;
                    }
                } else if (nums[i] > 9) {
                    continue;
                }
            }
            used[i] = true;
            track.push(nums[i]);
            timeSolution(nums, used, track, result);
            used[i] = false;
            track.pop();
        }
    }

    class TimeResult {
        public String maxTime;
        public String minTime;
    }
}
