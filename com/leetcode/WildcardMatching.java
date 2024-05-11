package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WildcardMatching {

    public static void main(String[] args) {
        WildcardMatching w = new WildcardMatching();
        System.out.println(w.isMatch("aa", "a")); // false
        System.out.println(w.isMatch("aa", "*")); // true
        System.out.println(w.isMatch("cb", "?a")); // false
        System.out.println(w.isMatch("adceb", "a*b")); // true
        System.out.println(w.isMatch("acdcb", "a*c?b")); // false
        System.out.println(w.isMatch("bcd", "??")); // false
        System.out.println(w.isMatch("ab", "?*")); // true
        System.out.println(w.isMatch("abcabczzzde", "*abc???de*")); // true
        System.out.println(w.isMatch("b", "?*?")); // false
        System.out.println(w.isMatch("ab", "*a")); // false
        System.out.println(w.isMatch("abefcdgiescdfimde", "ab*cd?i*de")); // true
        System.out.println(w.isMatch("aaab", "b**")); // false
        System.out.println(w.isMatch("mississippi", "m??*ss*?i*pi")); // false
        System.out.println(w.isMatch("abcede", "abc*d")); // false

        /*

        //start match
        System.out.println(w.search("stop", "s??", false, true, false));
        System.out.println(w.search("stop", "a", false, true, false));
        System.out.println(w.search("stop", "b", false, true, false));
        System.out.println(w.search("atop", "a", false, true, false));
        System.out.println(w.search("atop", "a?", false, true, false));
        System.out.println(w.search("atop", "a?b*", false, true, false));

        //end match
        System.out.println();
        System.out.println(w.search("stop", "??s", false, false, true));
        System.out.println(w.search("stop", "??p", false, false, true));
        System.out.println(w.search("stop", "t?p", false, false, true));
        System.out.println(w.search("stop", "top", false, false, true));
        System.out.println(w.search("stop", "atop", false, false, true));
        System.out.println(w.search("stop", "stop", false, false, true));
        System.out.println(w.search("stop", "opy", false, false, true));

        //exact match
        System.out.println();
        System.out.println(w.search("stop", "s???", false, true, false));
        System.out.println(w.search("stop", "s??p", false, true, false));
        System.out.println(w.search("stop", "st?p", false, true, false));
        System.out.println(w.search("stop", "stop", false, true, false));
        System.out.println(w.search("stop", "??top", false, true, false));
        System.out.println(w.search("stop", "?top", false, true, false));
        System.out.println(w.search("stop", "?to?", false, true, false));
        System.out.println(w.search("stop", "stopy", false, true, false));
        */

        /*
        System.out.println(w.simplifyPattern("**p**s?**?******"));
        System.out.println(w.simplifyPattern("****"));
        */

        /*
        Arrays.stream(w.getSubPatterns("*PQ***ab?*??***m*")).forEach(System.out::println);
        System.out.println();
        Arrays.stream(w.getSubPatterns("1PQ***ab?*??***m1")).forEach(System.out::println);
        System.out.println();
        Arrays.stream(w.getSubPatterns("anc")).forEach(System.out::println);
        System.out.println();
        Arrays.stream(w.getSubPatterns("*anc*")).forEach(System.out::println);
        System.out.println();
        Arrays.stream(w.getSubPatterns("**")).forEach(System.out::println);
        */
    }

    public boolean isMatch(String s, String p) {
        if (p.equals("")) {
            return s.equals("");
        }
        String asterisk = "*";
        p = simplifyPattern(p);

        if (p.equals(asterisk)) {
            return true;
        }

        boolean startMatchAll = !p.substring(0, 1).equals(asterisk);
        boolean endMatchAll = !p.substring(p.length() - 1).equals(asterisk);

        if (p.contains(asterisk)) {
            String[] subPatterns = getSubPatterns(p);
            String runningStr = s;
            for (int i = 0; i < subPatterns.length; i++) {
                boolean startMatch = startMatchAll && (i == 0);
                boolean endMatch = endMatchAll && i == subPatterns.length - 1;
                String subPattern = subPatterns[i];

                int idx = search(runningStr, subPattern, false, startMatch, endMatch);
                if (idx < 0) {
                    return false;
                }
                if (idx < runningStr.length() - 1) {
                    runningStr = runningStr.substring(idx + subPattern.length());
                } else if (i < subPatterns.length - 1) {
                    return false;
                }
            }
        } else {
            int idx = search(s, p, true, false, false);
            return idx > -1;
        }

        return true;
    }

    private String[] getSubPatterns(String p) {
        String asterisk = "*";
        List<String> subs = new ArrayList<>();
        String presentString = "";
        for (int i = 0; i < p.length(); i++) {
            if (p.substring(i, i + 1).equals(asterisk)) {
                if (presentString.length() > 0) {
                    subs.add(presentString);
                    presentString = "";
                }
            } else {
                presentString += p.substring(i, i + 1);
            }
        }
        if (presentString.length() > 0) {
            subs.add(presentString);
        }
        return subs.toArray(new String[0]);
    }


    private int search(String s, String p, boolean exactMatch, boolean startMatch, boolean endMatch) {
        String question = "?";

        if (s.length() < p.length() || (exactMatch && s.length() != p.length())) {
            return -1;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            int sIndex = i;
            int pIndex = 0;
            while (p.substring(pIndex, pIndex + 1).equals(question) || p.substring(pIndex, pIndex + 1).equals(s.substring(sIndex, sIndex + 1))) {
                pIndex++;
                sIndex++;
                if (pIndex == p.length() || sIndex == s.length()) {
                    break;
                }
            }
            if (startMatch) {
                return pIndex == p.length() ? 0 : -1;
            } else if (exactMatch) {
                return pIndex == p.length() && sIndex == s.length() ? 0 : -1;
            } else {
                if (pIndex == p.length()) {
                    if (!endMatch) {
                        return sIndex - pIndex;
                    } else {
                        if (sIndex == s.length()) {
                            return sIndex - pIndex;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private String simplifyPattern(String p) { // continuous asterisks are redundant
        String asterisk = "*";
        boolean asteriskRunning = false;
        String pNew = "";
        for (int i = 0; i < p.length(); i++) {
            String ch = p.substring(i, i + 1);
            if (ch.equals(asterisk)) {
                if (!asteriskRunning) {
                    pNew += ch;
                    asteriskRunning = true;
                }
            } else {
                pNew += ch;
                asteriskRunning = false;
            }
        }
        return pNew;
    }
}