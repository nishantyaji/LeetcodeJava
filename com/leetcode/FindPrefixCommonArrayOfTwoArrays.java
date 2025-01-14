package com.leetcode;

// Problem 2657
public class FindPrefixCommonArrayOfTwoArrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] aset = new int[A.length + 1];
        int[] bset = new int[B.length + 1];
        int[] res = new int[A.length];
        res[A.length - 1] = A.length;
        for (int i = A.length - 1; i > 0; i--) {
            if (aset[B[i]] > 0 && bset[A[i]] > 0) {
                res[i - 1] = res[i];
            } else if (B[i] == A[i] || aset[B[i]] > 0 || bset[A[i]] > 0) {
                res[i - 1] = res[i] - 1;
            } else {
                res[i - 1] = res[i] - 2;
            }
            aset[A[i]] = 1;
            bset[B[i]] = 1;
        }
        return res;
    }

}
