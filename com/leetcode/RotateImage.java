package com.leetcode;

public class RotateImage {

    public static void main(String[] args) {
        RotateImage r = new RotateImage();

        int[][] input1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        r.rotate(input1);
        r.displayMatrix(input1);
        System.out.println();
        System.out.println();

        int[][] input2 = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        r.rotate(input2);
        r.displayMatrix(input2);
        System.out.println();
        System.out.println();


        int[][] input3 = new int[][]{{1}};
        r.rotate(input3);
        r.displayMatrix(input3);
        System.out.println();
        System.out.println();


        int[][] input4 = new int[][]{{1, 2}, {3, 4}};
        r.rotate(input4);
        r.displayMatrix(input4);
        System.out.println();
        System.out.println();
    }

    private void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int length = matrix.length - 1;
        for (int row = 0; row < (matrix.length + 1) / 2; row++) {
            for (int column = row; column < matrix.length - 1 - row; column++) {
                int temp = matrix[row][column];
                matrix[row][column] = matrix[length - column][row];
                matrix[length - column][row] = matrix[length - row][length - column];
                matrix[length - row][length - column] = matrix[column][length - row];
                matrix[column][length - row] = temp;
            }
        }
    }
}
