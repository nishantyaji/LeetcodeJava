package com.leetcode;

public class SumOfSquareNumbers {

    public static void main(String[] args) {
        SumOfSquareNumbers s = new SumOfSquareNumbers();
        System.out.println(s.judgeSquareSum(3));
        System.out.println(s.judgeSquareSum(5));
        System.out.println(s.judgeSquareSum(0));
    }

    public boolean judgeSquareSum(int c) {
        if (c % 4 == 3) {
            return false;
        }
        int start = 0;
        if(c % 4 == 2 || c % 4 == 1) {
            start = 1;
        }
        for(int i = start; i <= Math.sqrt(c); i = i + 2) {
            if(isSquare(c - i * i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSquare(int c) {
        if (c == 0 || c == 1) {
            return true;
        }
        int sqrt = (int) Math.sqrt(c);
        return sqrt * sqrt == c;
    }
}
