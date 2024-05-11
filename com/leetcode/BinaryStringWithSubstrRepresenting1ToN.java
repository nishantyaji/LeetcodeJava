package com.leetcode;

public class BinaryStringWithSubstrRepresenting1ToN {
    public static void main(String[] args) {
        BinaryStringWithSubstrRepresenting1ToN b = new BinaryStringWithSubstrRepresenting1ToN();
        System.out.println(b.queryString("0110", 3));
        System.out.println(b.queryString("0110", 4));
        System.out.println(b.queryString("0110", 16));
    }

    public boolean queryString(String s, int n) {
        for (int i = n; i >= 1; i--) {
            String binStr = binaryString(i);
            if (!s.contains(binStr)) {
                return false;
            }
        }
        return true;
    }

    private String binaryString(int num) {
        String result = "";
        int r;
        while (num > 0) {
            r = num % 2;
            result = r + result;
            num = num / 2;
        }
        return result;
    }
}
