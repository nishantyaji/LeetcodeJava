package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSumII {
    public static void main(String[] args) {
        CombinationSumII c = new CombinationSumII();
        c.displayListOfLists(c.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println("------");
        c.displayListOfLists(c.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    private void displayListOfLists(List<List<Integer>> result) {
        for (List<Integer> entry : result) {
            for (Integer i : entry) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> candidateList = Arrays.stream(candidates).boxed().sorted().collect(Collectors.toList());
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < candidateList.size() && candidateList.get(i) <= target; i++) {
            if (candidateList.get(i) == target) {
                result.add(Collections.singletonList(candidateList.get(i)));
            } else {
                recurse(candidateList, i, target - candidateList.get(i), Collections.singletonList(candidateList.get(i)), result);
            }
        }
        return new ArrayList<>(result);
    }

    private void recurse(List<Integer> candidateList, int startIndex, int remainingTarget, List<Integer> ongoing, Set<List<Integer>> result) {
        if (candidateList.get(startIndex) <= remainingTarget) {
            for (int i = 1; startIndex + i < candidateList.size() && candidateList.get(startIndex + i) <= remainingTarget; i++) {
                List<Integer> onGoingCopy = new ArrayList<>(ongoing);
                onGoingCopy.add(candidateList.get(startIndex + i));
                if (candidateList.get(startIndex + i) == remainingTarget) {
                    result.add(onGoingCopy);
                }
                recurse(candidateList, startIndex + i, remainingTarget - candidateList.get(startIndex + i), onGoingCopy, result);
            }
        }
    }


}
