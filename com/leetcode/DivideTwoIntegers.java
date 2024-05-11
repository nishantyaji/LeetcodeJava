package com.leetcode;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers d = new DivideTwoIntegers();
        System.out.println(d.divide(-2147483648, 2));
        System.out.println(d.divide(-2147483648, -1));
        System.out.println(d.divide(10, 3));
        System.out.println(d.divide(-7, 3));
        System.out.println(d.divide(-7, 3));
        System.out.println(d.divide(0, 1));
        System.out.println(d.divide(1, 1));
        System.out.println(d.divide(-2147483648, -2));
        System.out.println(d.divide(-2147483648, 2));
        System.out.println(d.divide(-2147483648, -3));
        System.out.println(d.divide(-2147483648, 3));
        System.out.println(d.divide(-2147483648, -4));
        System.out.println(d.divide(-2147483648, 4));

    }

    public int divide(int dividend, int divisor) {
        long dividendLong = dividend;
        long divisorLong = divisor;
        if (dividendLong == 0) {
            return 0;
        }
        boolean isPositiveQ = (dividendLong > 0 && divisorLong > 0) || (dividendLong < 0 && divisorLong < 0);
        dividendLong = dividendLong > 0 ? dividendLong : -dividendLong;
        divisorLong = divisorLong > 0 ? divisorLong : -divisorLong;

        if (dividendLong < divisorLong) {
            return 0;
        }
        if (divisorLong == 1) {
            return checkBeforeReturn(isPositiveQ ? dividendLong : -dividendLong);
        }
        if (divisorLong == 2) {
            return checkBeforeReturn(isPositiveQ ? dividendLong >> 1 : -(dividendLong >> 1));
        }
        long result = 0;
        while (dividendLong >= divisorLong) {
            result++;
            dividendLong -= divisorLong;
        }
        int resultInt = (int) result;
        return checkBeforeReturn(isPositiveQ ? resultInt : -resultInt);
    }

    private static int checkBeforeReturn(long i) {
        long max = (long) Math.pow(2, 31) - 1;
        long min = (long) -Math.pow(2, 31);
        if (i > max) {
            return (int) max;
        } else if (i < min) {
            return (int) min;
        } else {
            return (int) i;
        }
    }
}
