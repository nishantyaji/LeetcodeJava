/* Problem 3043 */
package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LengthOfLongestCommonPrefix {


    public static void main(String[] args) {
        LengthOfLongestCommonPrefix l = new LengthOfLongestCommonPrefix();
        System.out.println(l.longestCommonPrefix(new int[]{41, 35, 30, 49, 8}, new int[]{23, 8, 12, 26, 14}));
        System.out.println(l.longestCommonPrefix(new int[]{13, 27, 45}, new int[]{21, 27, 48}));
        System.out.println(l.longestCommonPrefix(new int[]{1, 10, 100}, new int[]{1000}));
        System.out.println(l.longestCommonPrefix(new int[]{1, 2, 3}, new int[]{4, 4, 4}));


    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        List<String> array1 = Arrays.stream(arr1).mapToObj(Integer::toString).collect(Collectors.toList());
        List<String> array2 = Arrays.stream(arr2).mapToObj(Integer::toString).collect(Collectors.toList());

        HashMap<String, Trie> map = new HashMap<>();

        for (String a : array1) {
            String key = a.substring(0, 1);
            Trie t = map.computeIfAbsent(key, k -> new Trie(a));
            if (a.length() > 1) {
                t.set(a.substring(1));
            }
        }

        int maxLen = -1;
        for (String a : array2) {
            String start = a.substring(0, 1);
            if (!map.containsKey(start)) {
                maxLen = Math.max(0, maxLen);
            } else {
                int temp = 1;
                if (a.length() > 1) {
                    String next = a.substring(1);
                    temp = 1 + map.get(start).traverse(next);
                }
                maxLen = Math.max(maxLen, temp);
            }
        }

        return maxLen;


    }

    public static class Trie {
        String val;
        Trie[] children = new Trie[10];

        Trie(String n) {
            this.val = n;
        }

        public void set(String x) {
            int index = Integer.parseInt(x.substring(0, 1));
            if (this.children[index] == null) {
                this.children[index] = new Trie(Integer.toString(index));
            }
            if (x.length() > 1) {
                String nxt = x.substring(1);
                this.children[index].set(nxt);
            }
        }

        public int traverse(String x) {
            String start = x.substring(0, 1);
            int startIndex = Integer.parseInt(start);
            if (children[startIndex] == null) {
                return 0;
            } else {
                if (x.length() > 1) {
                    String next = x.substring(1);
                    return 1 + children[startIndex].traverse(next);
                } else {
                    return 1;
                }
            }
        }
    }
}
