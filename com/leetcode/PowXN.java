package com.leetcode;

public class PowXN {

    public static void main(String[] args) {
        PowXN p = new PowXN();
        System.out.println(p.myPow(2.0, -2147483648));
        System.out.println(p.myPow(-1, -2147483648));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0 || x == 1) {
            return x;
        }
        if(x == -1)
        {
            return n%2 == 0 ? 1 : -1;
        }
        long longn = n;
        if (n < 0) {
            x = 1 / x;
            longn = -1 * (long) n;
        }
        double result = 1;
        for (long i = 0; i < longn; i++) {
            result *= x;
            if (result > 10000 || result < -10000 || (result > 0 && result < 1e-5)) {
                return 0;
            }
        }

        return result;
    }
}
