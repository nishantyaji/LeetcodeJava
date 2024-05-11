package com.leetcode;

public class ZigZagConversion {

    public static void main(String[] args) {
        ZigZagConversion z  = new ZigZagConversion();
        System.out.println(z.convert("ABCDE", 4));
        System.out.println(z.convert("PAYPALISHIRING", 3));
        System.out.println(z.convert("PAYPALISHIRING", 4));
        System.out.println(z.convert("A", 1));
    }

    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        int width = findWidth(s.length(), numRows);
        String[][] output = new String[numRows][];
        for(int i = 0; i < numRows; i++) {
            output[i] = new String [width];
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < width; j++) {
                output[i][j] = "";
            }
        }

        int rowCord = 0;
        int colCord = 0;
        for (int i = 0; i < s.length(); i++) {
            int rem = (i + 1) % (2 * numRows - 2);
            output[rowCord][colCord] = s.substring(i, i+1);
            if (1 <= rem && rem < numRows) {
                rowCord++;
            } else {
                colCord++;
                rowCord--;
            }
        }

        String outputStr  = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < width; j++) {
                outputStr += output[i][j];
            }
        }

        return outputStr;
    }

    public int findWidth(int strLen, int numRows) {
        if(numRows == 1) {
            return strLen;
        }
        int q = strLen / (2 * numRows - 2);
        int width = (numRows - 1) * q;
        int rem = strLen % (2 * numRows - 2);
        if (rem <= numRows) {
            width++;
        } else {
            width += (rem - numRows);
        }
        return width+1;
    }
}
