package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> allPermutations = permute(new int [] {1, 2, 3});
        for(List<Integer> permutation: allPermutations) {
            System.out.println();
            permutation.forEach(num -> System.out.print(num + ","));
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        List<Integer> originalPermutation = new ArrayList<>();
        permutations(nums, originalPermutation, allPermutations);
        return allPermutations;
    }

    public static void permutations(int[] nums, List<Integer> thisPermutation, List<List<Integer>> allPermutations) {
        if (nums.length == 1) {
            List<Integer> myList = new ArrayList<>();
            myList.addAll(thisPermutation);
            myList.add(nums[0]);
            allPermutations.add(myList);
            return;
        }
        List<Integer> myList = new ArrayList<>();
        myList.addAll(thisPermutation);
        myList.add(nums[0]);
        permutations(Arrays.copyOfRange(nums, 1, nums.length), myList, allPermutations);
        for (int i = 1; i < nums.length; i++) {
            List<Integer> anotherList = new ArrayList<>();
            anotherList.addAll(thisPermutation);
            int[] myNums = swap(nums, 0, i);
            anotherList.add(myNums[0]);
            permutations(Arrays.copyOfRange(myNums, 1, nums.length), anotherList, allPermutations);
        }
    }

    public static int[] swap(int[] inputNums, int i, int j) {
        int[] nums = Arrays.copyOfRange(inputNums, 0, inputNums.length);
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
        return nums;
    }

}
