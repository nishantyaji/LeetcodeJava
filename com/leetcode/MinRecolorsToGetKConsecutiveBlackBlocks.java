package com.leetcode;


// Problem 2379
public class MinRecolorsToGetKConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {
        int [] arr = new int[blocks.length()];
        int window = 0, res = 0;
        for(int i = 0; i < blocks.length(); i++) {
            arr[i] = blocks.charAt(i) == 'B' ? 1 : 0;
            if(i < k) {
                window += arr[i];
                res = Math.max(res, window);
            }
        }
        for(int j = k; j < blocks.length(); j++) {
            window = window + arr[j] - arr[j - k];
            res = Math.max(res, window);
        }
        return k - res;
    }

}
