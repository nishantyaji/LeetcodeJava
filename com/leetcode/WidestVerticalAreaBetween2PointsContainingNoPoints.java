package com.leetcode;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class WidestVerticalAreaBetween2PointsContainingNoPoints {

    public static void main(String[] args) {
        WidestVerticalAreaBetween2PointsContainingNoPoints w = new WidestVerticalAreaBetween2PointsContainingNoPoints();
        System.out.println(w.maxWidthOfVerticalArea(new int[][]{{8, 7}, {9, 9}, {7, 4}, {9, 7}}));
        System.out.println(w.maxWidthOfVerticalArea(new int[][]{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}}));
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        Set<Integer> xCords = new TreeSet<>();
        for (int[] point : points) {
            xCords.add(point[0]);
        }
        Iterator<Integer> iterator = xCords.iterator();
        int area = 0;
        if (xCords.size() <= 1) {
            return area;
        }
        int prev = iterator.next();
        while (iterator.hasNext()) {
            int present = iterator.next();
            int diff = present - prev;
            if (diff > area) {
                area = diff;
            }
            prev = present;
        }
        return area;
    }
}
