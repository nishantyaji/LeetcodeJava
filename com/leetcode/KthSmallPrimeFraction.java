package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Problem 786
public class KthSmallPrimeFraction {


    public static void main(String[] args) {

    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<Fraction> fractions = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; i < arr.length; j++) {
                fractions.add(new Fraction(arr[i], arr[j]));
            }
        }
        fractions.sort(new FractionComparator());
        return new int[]{fractions.get(k - 1).numerator, fractions.get(k - 1).denominator};
    }

    public static class Fraction {
        int numerator;
        int denominator;

        public Fraction(int num, int den) {
            this.numerator = num;
            this.denominator = den;
        }
    }

    public static class FractionComparator implements Comparator<Fraction> {

        @Override
        public int compare(Fraction o1, Fraction o2) {
            return o1.numerator * o2.denominator - o1.denominator * o2.numerator;
        }
    }
}
