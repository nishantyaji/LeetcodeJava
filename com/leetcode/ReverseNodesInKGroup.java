package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
A lot of scope to trim this down.
I will do it someday
 */
public class ReverseNodesInKGroup {


    public ListNode getListFromArray(int[] array) {
        ListNode head = null;
        ListNode prev = null;
        for (int i = 0; i < array.length; i++) {
            ListNode curr = new ListNode(array[i]);
            if (i == 0) {
                head = curr;
            } else {
                prev.next = curr;
            }
            prev = curr;
        }
        prev.next = null;
        return head;
    }

    public void display(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup r = new ReverseNodesInKGroup();
        r.display(r.reverseKGroup(r.getListFromArray(new int[]{1, 2}), 2));
        r.display(r.reverseKGroup(r.getListFromArray(new int[]{1, 2, 3, 4, 5}), 3));
        r.display(r.reverseKGroup(r.getListFromArray(new int[]{1, 2, 3, 4, 5}), 2));
        r.display(r.reverseKGroup(r.getListFromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}), 4));
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        ListNode blockEnd = curr;
        int stackOps = 0;
        while (curr != null) {
            stack.add(curr);
            curr = curr.next;

            if (stack.size() == k) {
                ListNode prev = stack.pop();
                ListNode innerCurr = null;
                if (stackOps == 0) {
                    head = prev;
                } else {
                    blockEnd.next = prev;
                }
                while (stack.size() > 0) {
                    innerCurr = stack.pop();
                    prev.next = innerCurr;
                    prev = innerCurr;
                }
                blockEnd = innerCurr;
                stackOps += 1;
            }
        }

        // the following if block can be reduced and trimmed
        if (stack.size() == k) {
            ListNode prev = stack.pop();
            if (stackOps == 0) {
                head = prev;
            } else {
                blockEnd.next = prev;
            }
            while (stack.size() > 0) {
                curr = stack.pop();
                prev.next = curr;
            }
            blockEnd = curr;
            stackOps += 1;
        }

        List<ListNode> myList = new ArrayList<>();
        while (stack.size() > 0) {
            myList.add(0, stack.pop());
        }
        if (myList.size() > 0) {
            blockEnd.next = myList.get(0);
        } else {
            blockEnd.next = null;
        }

        for (int i = 1; i < myList.size(); i++) {
            blockEnd = blockEnd.next;
            blockEnd.next = myList.get(i);
        }
        if (blockEnd.next != null) {
            blockEnd.next.next = null;
        }

        return head;
    }

    public class ListNode {
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
