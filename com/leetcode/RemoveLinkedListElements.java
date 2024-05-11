package com.leetcode;

import java.util.Objects;

public class RemoveLinkedListElements {

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

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        if(Objects.isNull(head)) {
            return head;
        }
        ListNode present = head;
        while(present.val == val) {
            if(Objects.nonNull(present.next)) {
                present = present.next;
            } else {
                present = null;
                break;
            }
        }
        head = present;
        if(Objects.isNull(head)) {
            return head;
        }
        while(Objects.nonNull(present.next)) {
            if(present.next.val == val) {
                present.next = present.next.next;
            } else {
                present = present.next;
            }
        }
        return head;
    }
}
