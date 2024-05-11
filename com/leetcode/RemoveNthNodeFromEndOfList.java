package com.leetcode;


// Problem 19
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        int k = count - n + 1;
        if (k == 1) {
            return head.next;
        }

        node = head;
        ListNode prev = head;
        while (k - 1 > 0) {
            node = node.next;
            k--;
            prev = node;
        }

        prev.next = n == 1 ? null : node.next;
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
