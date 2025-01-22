package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// Problem 1765
public class MapOfHighestPeak {

    public static void main(String[] args) {
        MapOfHighestPeak m = new MapOfHighestPeak();
        int[][] isWater = new int[][]{{0, 1}, {0, 0}};
        int[][] result = m.highestPeak(isWater);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] highestPeak(int[][] isWater) {
        // Using the set is not quick
        // Changing the value and also storing visited flag in the same array is quicker
        int rows = isWater.length;
        int cols = isWater[0].length;
        Queue<Triplet> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new Triplet(i, j, 0));
                    isWater[i][j] = 0;
                } else {
                    isWater[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            Triplet t = q.poll();
            int x = t.x;
            int y = t.y;
            int val = t.value;

            if (0 <= x && x < rows - 1 && isWater[x + 1][y] == -1) {
                q.add(new Triplet(x + 1, y, val + 1));
                isWater[x + 1][y] = val + 1;
            }
            if (x > 0 && x <= rows - 1 && isWater[x - 1][y] == -1) {
                q.add(new Triplet(x - 1, y, val + 1));
                isWater[x - 1][y] = val + 1;
            }
            if (y >= 0 && y < cols - 1 && isWater[x][y + 1] == -1) {
                q.add(new Triplet(x, y + 1, val + 1));
                isWater[x][y + 1] = val + 1;
            }
            if (y > 0 && y <= cols - 1 && isWater[x][y - 1] == -1) {
                q.add(new Triplet(x, y - 1, val + 1));
                isWater[x][y - 1] = val + 1;
            }
        }
        return isWater;
    }

    public static class Triplet {
        int x;
        int y;
        int value;

        public Triplet(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.value = val;
        }
    }
}
