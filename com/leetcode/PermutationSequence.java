package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
        System.out.println(getPermutation(4, 1));
        System.out.println(getPermutation(4, 12));
        System.out.println(getPermutation(4, 18));
        System.out.println(getPermutation(4, 24));
        System.out.println(getPermutation(4, 23));
        System.out.println(getPermutation(3, 3));
    }

    static int[] factorial = new int[9];

    static {
        int cumulativeProd = 1;
        for (int i = 0; i < 9; i++) {
            cumulativeProd = cumulativeProd * (i + 1);
            factorial[i] = cumulativeProd;
        }
    }

    public static String getPermutation(int n, int k) {
        String result = "";
        List<Integer> myList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            myList.add(i);
        }
        String output = "";
        List<Integer> resultList = new ArrayList<>();
        getIntLeavingOut(k, myList, resultList);
        for (Integer num : resultList) {
            output = output + Integer.toString(num);
        }
        return output;
    }

    public static void getIntLeavingOut(int k, List<Integer> arranged, List<Integer> result) {
        if (k == 0) {
            while (arranged.size() > 0) {
                result.add(arranged.remove(arranged.size() - 1));
            }
            return;
        } else if(k == 1) {
            result.addAll(arranged);
            return;
        }
        int quotient = (int) (k-1) / factorial[arranged.size() - 2];
        int remainder = k % (factorial[arranged.size() - 2]);
        result.add(arranged.remove(quotient));
        getIntLeavingOut(remainder, arranged, result);
    }
}
