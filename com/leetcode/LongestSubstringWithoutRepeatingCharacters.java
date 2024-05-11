package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring(""));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<String, Integer> tracker = new HashMap<>();
        int currentStartIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            String presentChar = s.substring(i, i + 1);
            Integer lastPostForChar = tracker.get(presentChar);
            if (Objects.nonNull(lastPostForChar)) {
                if (lastPostForChar + 1 > currentStartIndex) {
                    currentStartIndex = lastPostForChar + 1;
                }
            }
            int presentLength = i - currentStartIndex + 1;
            if (presentLength > maxLength) {
                maxLength = presentLength;
            }
            tracker.put(presentChar, i);
        }
        return maxLength;
    }
}
