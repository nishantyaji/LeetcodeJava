package com.leetcode;

// Problem 1267
public class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[] rowFlags = new int[rowLen];
        int[] colFlags = new int[colLen];


        int total = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    rowFlags[i]++;
                    colFlags[j]++;
                    total++;
                }
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    if (rowFlags[i] == 1 && colFlags[j] == 1) {
                        total--;
                    }
                }
            }
        }
        return total;
    }
}
