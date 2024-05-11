package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        r.displayList(r.deleteDuplicates(r.getLinkedList(new int[]{1, 2, 3, 3, 4, 4, 5})));
        r.displayList(r.deleteDuplicates(r.getLinkedList(new int[]{1, 1, 1, 2, 3})));
    }

    private ListNode getLinkedList(int[] arr) {
        ListNode head = null;
        ListNode prev = null;
        for (int i = 0; i < arr.length; i++) {
            ListNode node;
            if (Objects.isNull(head)) {
                node = new ListNode();
                node.val = arr[i];
                head = node;
                prev = head;
            } else {
                node = new ListNode(arr[i]);
                prev.next = node;
                prev = node;
            }
            if (i == arr.length - 1) {
                node.next = null;
            }
        }
        return head;
    }

    private void displayList(ListNode head) {
        ListNode present = head;
        while (Objects.nonNull(present)) {
            System.out.print(present.val + ", ");
            present = present.next;
        }
        System.out.println();
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

    public ListNode deleteDuplicates(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode present = head;
        List<ListNode> uniqueList = new ArrayList<>();
        boolean hasBeenDuplicate = false;
        while (Objects.nonNull(present.next)) {
            if (present.next.val == present.val) {
                present = present.next;
                hasBeenDuplicate = true;
                continue;
            } else if (hasBeenDuplicate) {
                present = present.next;
                hasBeenDuplicate = false;
            } else {
                uniqueList.add(present);
                present = present.next;
            }
            if (Objects.isNull(present)) {
                return null;
            }
        }
        if (!hasBeenDuplicate) {
            uniqueList.add(present);
        }
        ListNode prev = null;
        ListNode headNew = null;
        for (int i = 0; i < uniqueList.size(); i++) {
            ListNode node = uniqueList.get(i);
            if (Objects.isNull(headNew)) {
                headNew = node;
                prev = node;
            } else {
                prev.next = node;
                prev = node;
            }
            if (i == uniqueList.size() - 1) {
                node.next = null;
            }
        }

        return headNew;
    }
}
