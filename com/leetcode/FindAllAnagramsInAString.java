package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        FindAllAnagramsInAString f = new FindAllAnagramsInAString();
        System.out.println(f.findAnagrams("cbaebabacd", "abc"));
        System.out.println(f.findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        Map<String, Integer> pMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            addToMap(pMap, p.substring(i, i + 1));
        }

        Map<String, Integer> runningSMap = new HashMap<>();
        for (int j = 0; j < p.length() - 1; j++) {
            addToMap(runningSMap, s.substring(j, j + 1));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; ; i++) {
            addToMap(runningSMap, s.substring(i + p.length() - 1, i + p.length()));
            if (runningSMap.equals(pMap)) {
                result.add(i);
            }
            if (i < s.length() - p.length()) {
                removeFromMap(runningSMap, s.substring(i, i + 1));
            } else {
                break;
            }
        }
        return result;
    }

    private void addToMap(Map<String, Integer> map, String s) {
        int count = 1;
        if (map.containsKey(s)) {
            count = map.get(s);
            count++;
        }
        map.put(s, count);
    }

    private void removeFromMap(Map<String, Integer> map, String s) {
        if (map.containsKey(s)) {
            int count = map.get(s);
            count--;
            if (count == 0) {
                map.remove(s);
            } else {
                map.put(s, count);
            }
        } else {
            throw new RuntimeException(s + " is not present in the map");
        }
    }
}
