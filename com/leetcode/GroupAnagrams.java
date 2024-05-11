package com.leetcode;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<List<String>> returnStrings = groupAnagrams(new String [] {"eat","tea","tan","ate","nat","bat"});
        for(List<String> group: returnStrings) {
            System.out.println();
            group.forEach(str -> System.out.print(str + ","));
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> ourTable = new HashMap<>();

        for (String str : strs) {
            List<Integer> strKey = keyValue(str);
            if (ourTable.containsKey(strKey)) {
                List<String> value = ourTable.get(strKey);
                value.add(str);
                ourTable.put(strKey, value);
            } else{
                List<String> firstVal = new ArrayList<>();
                firstVal.add(str);
                ourTable.put(strKey, firstVal);
            }
        }

        List<List<String>> ourReturn = new ArrayList<>();
        for (List<String> values : ourTable.values()) {
            ourReturn.add(values);
        }
        return ourReturn;

    }

    private static List<Integer> keyValue(String str) {
        List<Integer> key = new ArrayList();
        for (int i = 0; i < 26; i++) {
            key.add(0);
        }
        char[] chars = str.toCharArray();
        for (char c : chars) {
            int keyForChar = (int) c - (int) 'a';
            int count = key.get(keyForChar);
            count++;
            key.set(keyForChar, count);
        }
        return key;
    }
}
