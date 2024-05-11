package com.leetcode;

import java.util.*;

public class MaxPointsOnALine {
    private Map<List<Integer>, Set<List<Integer>>> slopeAndInterceptToPointsMap = new HashMap<>();

    public static void main(String[] args) {
        MaxPointsOnALine m = new MaxPointsOnALine();
        System.out.println(m.maxPoints(new int[][]{{3, 3}, {1, 4}, {1, 1}, {2, 1}, {2, 2}}));
        System.out.println(m.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(m.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }

    public int maxPoints(int[][] points) {
        if (points.length == 0 || points.length == 1) {
            return points.length;
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] slope = slopeFn(points[i], points[j]);
                int[] intercept = interceptFn(points[i], points[j]);
                addToMap(slope, intercept, points[i], points[j]);
            }
        }
        //findMaxInALine();
        int max = Integer.MIN_VALUE;
        for (Set<List<Integer>> val : slopeAndInterceptToPointsMap.values()) {
            if (max < val.size()) {
                max = val.size();
            }
        }
        return max;
    }

    private void addToMap(int[] slope, int[] intercept, int[] point1, int[] point2) {
        List<Integer> slopeAndIntercept = new ArrayList<>();
        slopeAndIntercept.add(slope[0]);
        slopeAndIntercept.add(slope[1]);
        slopeAndIntercept.add(intercept[0]);
        slopeAndIntercept.add(intercept[1]);
        List<Integer> point1List = new ArrayList<>();
        point1List.add(point1[0]);
        point1List.add(point1[1]);
        List<Integer> point2List = new ArrayList<>();
        point2List.add(point2[0]);
        point2List.add(point2[1]);
        if (slopeAndInterceptToPointsMap.containsKey(slopeAndIntercept)) {
            Set<List<Integer>> value = slopeAndInterceptToPointsMap.get(slopeAndIntercept);
            value.add(point1List);
            value.add(point2List);
        } else {
            Set<List<Integer>> value = new HashSet<>();
            value.add(point1List);
            value.add(point2List);
            slopeAndInterceptToPointsMap.put(slopeAndIntercept, value);
        }
    }

    private int[] interceptFn(int[] point1, int[] point2) {
        int numerator = point2[0] * point1[1] - point1[0] * point2[1];
        int denominator = point2[0] - point1[0];
        //denominator is always positive, the numerator can be of any sign
        if (numerator == 0) {
            denominator = 1;
        } else if (denominator == 0) {
            numerator = Integer.MAX_VALUE;
            denominator = 1;
        } else {
            int gcd = gcdFn(Math.abs(denominator), Math.abs(numerator));
            denominator /= gcd;
            numerator /= gcd;
        }

        if ((denominator < 0 && numerator < 0) || (denominator < 0 && numerator > 0)) {
            denominator = -1 * denominator;
            numerator = -1 * numerator;
        }
        return new int[]{numerator, denominator};
    }

    private int[] slopeFn(int[] point1, int[] point2) {
        int denominator = point1[0] - point2[0];
        int numerator = point1[1] - point2[1];
        //denominator is always positive, the numerator can be of any sign
        if (numerator == 0) {
            denominator = 1;
        } else if (denominator == 0) {
            numerator = Integer.MAX_VALUE;
            denominator = point1[0];
        } else {
            int gcd = gcdFn(Math.abs(denominator), Math.abs(numerator));
            denominator /= gcd;
            numerator /= gcd;
        }

        if ((denominator < 0 && numerator < 0) || (denominator < 0 && numerator > 0)) {
            denominator = -1 * denominator;
            numerator = -1 * numerator;
        }
        return new int[]{numerator, denominator};
    }

    private int gcdFn(int num1, int num2) {
        if (num1 < num2) {
            int swap = num1;
            num1 = num2;
            num2 = swap;
        } // num1 is always greater than or equal to num2 now

        int rem = Integer.MAX_VALUE;
        while (rem > 0) {
            rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }
        return num1;
    }
}