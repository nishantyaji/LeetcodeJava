package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstringsWithOnly1s {

    public static void main(String[] args) {
        NumberOfSubstringsWithOnly1s n = new NumberOfSubstringsWithOnly1s();
        System.out.println(n.numSub("0110111"));
        System.out.println(n.numSub("101"));
        System.out.println(n.numSub("111111"));
        System.out.println(n.numSub(""));
    }

    public int numSub(String s) {
        int runningCountOfOnes = 0;
        long moduloBase = (long) 1e9 + 7;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals("1")) {
                runningCountOfOnes++;
            } else {
                if (runningCountOfOnes > 0) {
                    addToMap(map, runningCountOfOnes);
                    runningCountOfOnes = 0;
                }
            }
        }
        if (runningCountOfOnes > 0) {
            addToMap(map, runningCountOfOnes);
        }
        long finalResult = 0;
        for (int length : map.keySet()) {
            int evenOne = length % 2 == 0 ? length : length + 1;
            int oddOne = length % 2 == 0 ? length + 1 : length;
            long res = evenOne / 2;
            res = (res * oddOne) % moduloBase;
            res = (res * map.get(length)) % moduloBase;
            finalResult += res;
        }
        return (int) finalResult;
    }

    private void addToMap(Map<Integer, Integer> map, int numOnes) {
        if (map.containsKey(numOnes)) {
            map.put(numOnes, map.get(numOnes) + 1);
        } else {
            map.put(numOnes, 1);
        }
    }
}
