package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Solution to the leet code Problem 502
 */
public class IPO {
    public static void main(String[] args) {
        IPO i = new IPO();
        System.out.println(i.findMaximizedCapital(1, 0,
                getArrayFromString("[1,2,3]"),
                getArrayFromString("[0,1,2]")));
        System.out.println(i.findMaximizedCapital(2, 0,
                getArrayFromString("[1,2,3]"),
                getArrayFromString("[0,1,1]")));
        System.out.println(i.findMaximizedCapital(3, 0,
                getArrayFromString("[1,2,3]"),
                getArrayFromString("[0,1,2]")));
    }

    /**
     * This is a util function through which I can copy+paste
     * the popular array notation from competitive programming websites
     *
     * @param s popular array notation in the format "[x, y, z ...]"
     * @return int array in java. this is equivalent to
     * {@code new int [] {x, y, z};}
     */
    public static int[] getArrayFromString(String s) {
        int i = 0;
        while (s.charAt(i) == '[') {
            i++;
        }
        String[] tokens = s.substring(i, s.length() - 1).split(",");
        int[] array = new int[tokens.length];
        i = 0;
        for (String token : tokens) {
            array[i++] = Integer.parseInt(token);
        }
        return array;
    }


    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            pairs.add(new Pair(i, capital[i]));
        }
        pairs.sort(new PairComparator());

        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while (k > 0 && index < profits.length) {
            while (index < profits.length && pairs.get(index).capital <= w) {
                pq.add(profits[pairs.get(index).index]);
                index++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            }
            k--;
        }
        while (k > 0) {
            if (!pq.isEmpty()) {
                w += pq.poll();
            }
            k--;
        }
        return w;
    }

    public static class Pair {
        int index;
        int capital;

        Pair(int i, int c) {
            index = i;
            capital = c;
        }
    }

    public static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.capital == o2.capital) {
                return o1.index - o2.index;
            }
            return o1.capital - o2.capital;
        }
    }
}
