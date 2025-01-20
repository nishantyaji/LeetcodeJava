package com.leetcode;

public class FirstCompletelyPaintedRowOrColumn {

    // Problem 2661
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int i, j;
        int[] rowCount = new int[mat.length];
        for (i = 0; i < rowCount.length; i++) {
            rowCount[i] = mat[0].length;
        }
        int[] colCount = new int[mat[0].length];
        for (i = 0; i < colCount.length; i++) {
            colCount[i] = mat.length;
        }
        int[] rowLabel = new int[arr.length];
        int[] colLabel = new int[arr.length];
        for (i = 0; i < rowCount.length; i++) {
            for (j = 0; j < colCount.length; j++) {
                int val = mat[i][j];
                rowLabel[val - 1] = i;
                colLabel[val - 1] = j;
            }
        }

        for (i = 0; i < arr.length; i++) {
            rowCount[rowLabel[arr[i] - 1]]--;
            colCount[colLabel[arr[i] - 1]]--;
            if (rowCount[rowLabel[arr[i] - 1]] == 0 || colCount[colLabel[arr[i] - 1]] == 0) {
                return i;
            }
        }
        return i - 1;
    }
}
