package com.leetcode;


public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        //  Can be implemented using priority queue also
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode prev = null;
        while (true) {
            int minIndex = -1;
            int minValue = 100001;
            boolean allNull = true;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    allNull = false;
                    if (lists[i].val < minValue) {
                        minIndex = i;
                        minValue = lists[i].val;
                    }
                }
            }
            if (allNull) {
                break;
            }
            if (prev == null) {
                prev = new ListNode(minValue);
                head = prev;
            } else {
                ListNode curr = new ListNode(minValue);
                prev.next = curr;
                prev = curr;
            }
            lists[minIndex] = lists[minIndex].next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
