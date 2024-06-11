package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Solution to the leet code problem 1122
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            if (!map.containsKey(arr2[i])) {
                map.put(arr2[i], 0);
            }
        }

        List<Integer> others = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                others.add(arr1[i]);
            }
        }
        int[] result = new int[arr1.length];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            while (value > 0) {
                result[i++] = entry.getKey();
                value--;
            }
        }

        Collections.sort(others);
        while (others.size() > 0) {
            result[i++] = others.remove(0);
        }
        return result;
    }
}
