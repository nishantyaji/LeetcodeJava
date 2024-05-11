package com.leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        KthLargestElementInArray k = new KthLargestElementInArray();
        System.out.println(k.findKthLargest(new int []{3,2,1,5,6,4}, 2));
        System.out.println(k.findKthLargest(new int []{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else {
                if (num > pq.peek()) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        return pq.peek();
    }
}
