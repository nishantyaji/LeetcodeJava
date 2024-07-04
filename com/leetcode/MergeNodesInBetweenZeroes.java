package com.leetcode;

/**
 * Problem 2181
 */
public class MergeNodesInBetweenZeroes {

    public ListNode mergeNodes(ListNode head) {

        head = head.next;
        int runSum = 0;
        ListNode result = null, prev = null;
        while(head != null) {
            if(head.val != 0) {
                runSum += head.val;
            } else{
                if(result == null && runSum > 0) {
                    result = new ListNode(runSum);
                    prev = result;
                } else if(runSum > 0){
                    ListNode present = new ListNode(runSum);
                    prev.next = present;
                    prev = present;
                }
                runSum = 0;
            }
            head = head.next;
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
