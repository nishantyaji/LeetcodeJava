package com.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Solution to the leet code Problem 1438
 */
public class LongestContinuousSubarrayAbsDiffLTEToLimit {
    public static void main(String[] args) {
        LongestContinuousSubarrayAbsDiffLTEToLimit l = new LongestContinuousSubarrayAbsDiffLTEToLimit();
        System.out.println(l.longestSubarray(getArrayFromString("[10,1,2,4,7,2]"), 5));
        System.out.println(l.longestSubarray(getArrayFromString("[4,2,2,2,4,4,2,2]"), 0));
        System.out.println(l.longestSubarray(getArrayFromString("[8,2,4,7]"), 4));
    }

    /**
     * This is a util function through which I can copy+paste
     * the popular array notation from competitive programming websites
     *
     * @param s popular array notation in the format "[x, y, z ...]"
     * @return int array in java. this is equivalent to
     * {@code new int [] {x, y, z};}
     */
    public static int[] getArrayFromString(String s) {
        int i = 0;
        while (s.charAt(i) == '[') {
            i++;
        }
        String[] tokens = s.substring(i, s.length() - 1).split(",");
        int[] array = new int[tokens.length];
        i = 0;
        for (String token : tokens) {
            array[i++] = Integer.parseInt(token);
        }
        return array;
    }

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();

        int i = 0, j = 0, len = 0;
        while (i <= j && j <= nums.length - 1) {
            if (!tMap.isEmpty() && tMap.lastKey() - tMap.firstKey() > limit) {
                tMap.put(nums[i], tMap.get(nums[i]) - 1);
                if (tMap.get(nums[i]) == 0) {
                    tMap.remove(nums[i]);
                }
                i++;
            } else {
                int thisLen = sumMap(tMap);
                if (thisLen > len) {
                    len = thisLen;
                }
                if (!tMap.containsKey(nums[j])) {
                    tMap.put(nums[j], 0);
                }
                tMap.put(nums[j], tMap.get(nums[j]) + 1);
                j++;
            }
        }
        if (tMap.lastKey() - tMap.firstKey() <= limit) {
            int thisLen = sumMap(tMap);
            if (thisLen > len) {
                len = thisLen;
            }
        }
        return len;
    }

    public int sumMap(TreeMap<Integer, Integer> map) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result += entry.getValue();
            ;
        }
        return result;
    }
}
