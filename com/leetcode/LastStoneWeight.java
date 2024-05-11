package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        LastStoneWeight l = new LastStoneWeight();
        System.out.println(l.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for (int i : stones) {
            pq.add(i);
        }
        while (pq.size() > 1) {
            int largest = pq.poll();
            int secondLargest = pq.poll();
            pq.add(largest - secondLargest);
        }
        return pq.poll();
    }
}
