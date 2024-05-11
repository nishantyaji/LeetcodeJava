package com.leetcode;

import java.util.Arrays;

public class MinChangesToAlternatingBinaryString {
    public static void main(String[] args) {
        MinChangesToAlternatingBinaryString m = new MinChangesToAlternatingBinaryString();
        System.out.println(m.minOperations("0101101"));
        System.out.println(m.minOperations("101000"));
        System.out.println(m.minOperations("0100"));
        System.out.println(m.minOperations("10"));
        System.out.println(m.minOperations("1111"));
    }

    public int minOperations(String s) {
        String zero = "0";
        int res = 0;
        if (s.length() == 0) {
            return res;
        }

        int headAltZeros = 0;
        int headAltOnes = 0;
        int nonHeadAltZeros = 0;
        int nonHeadAltOnes = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean isZero = s.substring(i, i + 1).equals(zero);
            if (i % 2 == 0) {
                if (isZero) {
                    headAltZeros++;
                } else {
                    headAltOnes++;
                }
            } else {
                if (isZero) {
                    nonHeadAltZeros++;
                } else {
                    nonHeadAltOnes++;
                }
            }
        }

        int headTotal = (s.length() + 1) / 2;
        int nonHeadTotal = (s.length() / 2);

        int min = Arrays.asList(headTotal - headAltOnes, headTotal - headAltZeros, nonHeadTotal - nonHeadAltOnes, nonHeadTotal - nonHeadAltZeros).stream().min((a, b) -> a - b).get();

        if (min == headTotal - headAltOnes) {
            return headTotal - headAltOnes + nonHeadTotal - nonHeadAltZeros;
        } else if (min == headTotal - headAltZeros) {
            return headTotal - headAltZeros + nonHeadTotal - nonHeadAltOnes;
        } else if (min == nonHeadTotal - nonHeadAltOnes) {
            return nonHeadTotal - nonHeadAltOnes + headTotal - headAltZeros;
        } else {
            return nonHeadTotal - nonHeadAltZeros + headTotal - headAltOnes;
        }
    }
}
