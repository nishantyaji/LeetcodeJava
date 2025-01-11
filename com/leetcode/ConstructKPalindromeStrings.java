package com.leetcode;

import java.util.HashMap;
import java.util.Map;

// Problem 1400
public class ConstructKPalindromeStrings {

    public static void main(String[] args) {
        ConstructKPalindromeStrings c = new ConstructKPalindromeStrings();
        System.out.println(c.canConstruct("annabelle", 2));
    }

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        Map<String, Integer> map = new HashMap<>();
        int odds = 0;
        for (int i = 0; i < s.length(); i++) {
            String subs = s.substring(i, i + 1);
            if (!map.containsKey(subs)) {
                map.put(subs, 0);
            }
            map.put(subs, map.get(subs) + 1);
            if (map.get(subs) % 2 == 1) {
                odds++;
            } else {
                odds--;
            }
        }
        return odds <= k;
    }

}
