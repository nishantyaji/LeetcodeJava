package com.leetcode;

import java.util.*;

// Problem 3160
public class FindNumOfDistinctColorsAmongBalls {

    public static void main(String[] args) {
        FindNumOfDistinctColorsAmongBalls f = new FindNumOfDistinctColorsAmongBalls();
        System.out.println(Arrays.toString(f.queryResults(3, new int[][]{{1, 4}, {2, 5}, {1, 3}, {3, 4}})));
    }

    public int change(Map<Integer, Integer> mp, Map<Integer, Integer> latest, int index, int value, List<Integer> counter) {
        if (latest.containsKey(index)) {
            int prevValue = latest.get(index);
            int temp = mp.get(prevValue);
            mp.put(prevValue, temp - 1);
            if (temp == 1) {
                counter.set(0, counter.get(0) - 1);
                mp.remove(prevValue);
            }
        }
        if (!mp.containsKey(value)) {
            counter.set(0, counter.get(0) + 1);
            mp.put(value, 0);
        }
        mp.put(value, mp.get(value) + 1);
        latest.put(index, value);
        return counter.get(0);
    }

    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> mp = new HashMap<>();
        Map<Integer, Integer> latest = new HashMap<>();
        List<Integer> counter = new ArrayList<>();
        counter.add(0);

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = change(mp, latest, queries[i][0], queries[i][1], counter);
        }
        return res;
    }
}
