package com.leetcode;

import javafx.util.Pair;

import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        NextGreaterElement2 n = new NextGreaterElement2();
        displayArray(n.nextGreaterElements(new int[]{1, 2, 1}));
        displayArray(n.nextGreaterElements(new int[]{1, 2, 3, 4, 3}));
    }

    private static void displayArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>(); // Pair<Value, Idx>
        int[] result = new int[nums.length];
        for (int i = 0; i < 2 * nums.length - 1; i++) {
            if (stack.isEmpty()) {
                stack.push(new Pair<>(nums[i], i));
            } else {
                while (!stack.isEmpty() && stack.peek().getKey() < nums[i % nums.length]) {
                    Pair<Integer, Integer> top = stack.pop();
                    result[top.getValue() % nums.length] = nums[i % nums.length];
                }
                if (i < nums.length) {
                    stack.push(new Pair<>(nums[i], i));
                }
            }
        }
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> top = stack.pop();
            result[top.getValue() % nums.length] = -1;
        }
        return result;
    }
}
