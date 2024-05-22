package com.leetcode;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

//Problem no 239
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        displayArray(s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        displayArray(s.maxSlidingWindow(new int[]{1}, 1));
    }

    private static void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    private void addToMap(Map<Integer, Integer> map, int num) {
        if (!map.containsKey(num)) {
            map.put(num, 0);
        }
        map.put(num, map.get(num) + 1);
    }

    private void removeFromMap(Map<Integer, Integer> map, int num) {
        if (map.containsKey(num)) {
            int count = map.get(num);
            if (count == 1) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Map<Integer, Integer> window = new TreeMap<>(Collections.reverseOrder());

        int[] maxArray = new int[nums.length - k + 1];
        int maxIdx = 0;

        int i = 0;
        for (; i < k - 1; i++) {
            addToMap(window, nums[i]);
        }

        while (maxIdx < maxArray.length) {
            addToMap(window, nums[i++]);
            maxArray[maxIdx++] = ((TreeMap<Integer, Integer>) window).firstKey();
            removeFromMap(window, nums[i - k]);
        }

        return maxArray;
    }


}
