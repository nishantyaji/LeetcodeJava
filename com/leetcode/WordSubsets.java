package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Problem 916
public class WordSubsets {

    public static void main(String[] args) {
        WordSubsets w = new WordSubsets();
        List<String> words = w.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "o"});
        for (String s : words) {
            System.out.println(s);
        }
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        Map<String, Map<String, Integer>> words1Map = new HashMap<>();
        Map<String, Integer> unifiedMap = new HashMap<>();
        for (String s : words1) {
            words1Map.put(s, formCounter(s));
        }
        for (String s : words2) {
            Map<String, Integer> w2Map = formCounter(s);
            for (Map.Entry<String, Integer> entry : w2Map.entrySet()) {
                if (!unifiedMap.containsKey(entry.getKey())) {
                    unifiedMap.put(entry.getKey(), 1);
                }
                unifiedMap.put(entry.getKey(), Math.max(unifiedMap.get(entry.getKey()), entry.getValue()));
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Map<String, Integer>> entry : words1Map.entrySet()) {
            if (isSubset(unifiedMap, entry.getValue())) {
                res.add(entry.getKey());
            }
        }
      return res;
    }

    private Map<String, Integer> formCounter(String s) {
        Map<String, Integer> thisMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(i, i + 1);
            if (!thisMap.containsKey(subStr)) {
                thisMap.put(subStr, 0);
            }
            thisMap.put(subStr, thisMap.get(subStr) + 1);
        }
        return thisMap;
    }

    private boolean isSubset(Map<String, Integer> sub, Map<String, Integer> sup) {
        for (Map.Entry<String, Integer> entry : sub.entrySet()) {
            Object supVal = sup.get(entry.getKey());
            if (supVal == null || (int) supVal < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
