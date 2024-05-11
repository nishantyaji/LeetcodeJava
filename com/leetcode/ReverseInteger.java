package com.leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(123));
        System.out.println(r.reverse(-123));
        System.out.println(r.reverse(120));
        System.out.println(r.reverse(1534236469));
    }

    public int reverse(int x) {
        int minNegative = (int) Math.pow(2, 31);
        int maxPositive = (int) Math.pow(2, 31) - 1;
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -1 * x;
        }

        if ((isNegative && x > minNegative) || (!isNegative && x > maxPositive)) {
            return 0;
        }

        long reverseX = 0;
        long loopVar = x;
        while (loopVar > 0) {
            long rem = loopVar % 10;
            loopVar = loopVar / 10;
            reverseX = 10 * reverseX + rem;
        }

        if (isNegative) {
            reverseX = reverseX * -1;
        }
        if (reverseX > maxPositive || reverseX < -1 * minNegative) {
            return 0;
        }
        return (int) reverseX;
    }
}
