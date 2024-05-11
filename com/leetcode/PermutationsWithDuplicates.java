package com.leetcode;

import java.util.*;

public class PermutationsWithDuplicates {
    public static void main(String[] args) {
        //https://leetcode.com/problems/permutations-ii/submissions/
//        List<List<Integer>> allPermutations = permuteUnique(new int [] {1,1, 2});
        // Please improve this. The number of loops can be decreased
        List<List<Integer>> allPermutations = permuteUnique(new int [] {3,3,0,3});
        for (List<Integer> perm: allPermutations) {
            System.out.print("[");
            perm.forEach(num -> System.out.print(num + ","));
            System.out.print("],");
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> allPermutations = new HashSet<>();
        List<Integer> presentPermutation = new ArrayList<>();
        permutation(allPermutations, presentPermutation, nums);
        List<List<Integer>> returnList = new ArrayList<>();
        returnList.addAll(allPermutations);
        return returnList;
    }

    public static void permutation(Set<List<Integer>> allPermutation, List<Integer> presentPermutation, int[] remainingNums) {
        if(remainingNums.length == 1) {
            presentPermutation.add(remainingNums[0]);
            allPermutation.add(presentPermutation);
            return;
        }
        else if (remainingNums.length == 2) {
            if (remainingNums[0] != remainingNums[1]) {
                List<Integer> firstPerm = new ArrayList<>();
                firstPerm.addAll(presentPermutation);
                firstPerm.add(remainingNums[0]);
                firstPerm.add(remainingNums[1]);
                List<Integer> secondPerm = new ArrayList<>();
                secondPerm.addAll(presentPermutation);
                secondPerm.add(remainingNums[1]);
                secondPerm.add(remainingNums[0]);
                allPermutation.add(firstPerm);
                allPermutation.add(secondPerm);
            } else{
                List<Integer> onlyPerm = new ArrayList<>();
                onlyPerm.addAll(presentPermutation);
                onlyPerm.add(remainingNums[0]);
                onlyPerm.add(remainingNums[1]);
                allPermutation.add(onlyPerm);
            }
            return;
        }
        List<Integer> myNewPerm = new ArrayList<>();
        myNewPerm.addAll(presentPermutation);
        myNewPerm.add(remainingNums[0]);
        permutation(allPermutation, myNewPerm, Arrays.copyOfRange(remainingNums, 1, remainingNums.length));
        int[] newNums = Arrays.copyOfRange(remainingNums, 0, remainingNums.length);
        for (int i = 1; i < newNums.length; i++) {
            if (newNums[i] != newNums[0]) {
                List<Integer> anotherPerm = new ArrayList<>();
                int swap = newNums[0];
                newNums[0] = newNums[i];
                newNums[i] = swap;
                anotherPerm.addAll(presentPermutation);
                anotherPerm.add(newNums[0]);
                permutation(allPermutation, anotherPerm, Arrays.copyOfRange(newNums, 1, newNums.length));
            }
        }
    }
}
