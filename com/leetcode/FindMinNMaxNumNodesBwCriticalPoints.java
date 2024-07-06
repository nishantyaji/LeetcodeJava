package com.leetcode;

/**
 * Solution to the leet code problem 2058
 */
public class FindMinNMaxNumNodesBwCriticalPoints {

    public static void main(String[] args) {
        FindMinNMaxNumNodesBwCriticalPoints f = new FindMinNMaxNumNodesBwCriticalPoints();
        f.display(f.nodesBetweenCriticalPoints(f.build(getArrayFromString("[3,1]"))));
        f.display(f.nodesBetweenCriticalPoints(f.build(getArrayFromString("[5,3,1,2,5,1,2]"))));
        f.display(f.nodesBetweenCriticalPoints(f.build(getArrayFromString("[1,3,2,2,3,2,2,2,7]"))));
    }

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

    public void display(int[] o) {
        for (int j : o) {
            System.out.print(j + ",");
        }
        System.out.println();
    }

    public ListNode build(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode prev = null;
        ListNode present = head;
        int index = 1;
        while (index <= arr.length) {
            present = new ListNode(arr[index - 1]);
            if (prev != null) {
                prev.next = present;
            } else {
                head = present;
            }
            prev = present;
            index++;
        }
        return head;
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int prevCrit = -1;
        ListNode prev = null;
        int minDist = Integer.MAX_VALUE;
        int maxDist = -1;
        int index = 1;
        int minIndex = -1;
        while (head != null) {
            if (prev != null && head.next != null &&
                    ((prev.val > head.val && head.next.val > head.val) || (prev.val < head.val && head.next.val < head.val))) {
                if (prevCrit > -1) {
                    minDist = Math.min(index - prevCrit, minDist);
                    maxDist = Math.max(index - minIndex, maxDist);
                } else {
                    minIndex = index;
                }
                prevCrit = index;
            }
            index++;
            prev = head;
            head = head.next;
        }
        if (minDist == Integer.MAX_VALUE) {
            minDist = -1;
        }
        return new int[]{minDist, maxDist};
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
