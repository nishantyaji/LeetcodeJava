package com.leetcode;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin k = new KClosestPointsToOrigin();
        displayArray(k.kClosest(new int [][]{{1,3},{-2,2}}, 1));
        displayArray(k.kClosest(new int [][]{{1,3},{-2,2}}, 2));
        displayArray(k.kClosest(new int [][]{{3,3},{5,-1},{-2,4}}, 2));
    }

    private static void displayArray(int [][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public class Point{
        private int x;
        private int y;
        private int squareDistance;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.squareDistance = x*x + y*y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(k, (o1, o2) -> -(o1.squareDistance - o2.squareDistance));
        for (int[] coords : points) {
            Point presentPoint = new Point(coords[0], coords[1]);
            if (pq.size() < k) {
                pq.add(presentPoint);
            } else {
                if (presentPoint.squareDistance < pq.peek().squareDistance) {
                    pq.poll();
                    pq.add(presentPoint);
                }
            }
        }
        int [][] returnArray = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()) {
            Point p = pq.poll();
            returnArray[i][0] = p.x;
            returnArray[i][1] = p.y;
            i++;
        }
        return returnArray;
    }
}
