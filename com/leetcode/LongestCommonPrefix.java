package com.leetcode;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println(l.longestCommonPrefix(new String[0]));
        System.out.println(l.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(l.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String baseStr = strs[0];
        String lcp = "";
        for (int i = 0; i < baseStr.length(); i++) {
            boolean matched = true;
            String s = baseStr.substring(i, i + 1);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || !strs[j].substring(i, i + 1).equals(s)) {
                    matched = false;
                    break;
                }
            }
            if (!matched) {
                break;
            } else {
                lcp = lcp + s;
            }
        }
        return lcp;
    }
}
