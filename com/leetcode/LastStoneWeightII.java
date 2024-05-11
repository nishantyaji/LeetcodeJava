package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LastStoneWeightII {
    public static void main(String[] args) {
        LastStoneWeightII l = new LastStoneWeightII();
        System.out.println(l.lastStoneWeightII(new int[]{31, 26, 33, 21, 40}));
        System.out.println(l.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));

    }

    public int lastStoneWeightII(int[] stones) {
        return twoEqualGroups(stones);
    }

    private int twoEqualGroups(int[] stones) {
        List<List<Integer>> groups = new ArrayList<>();

        int sum = 0;
        for (int i : stones) {
            sum += i;
        }

        int desiredWeight = sum / 2;

        /*
         * dp[i][j] has the maximum value of j weight considering all value from 1st to i'th weight
         *
         */
        int[][] dp = new int[stones.length + 1][desiredWeight + 1];

        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j <= desiredWeight; j++) {
                /*
                 * We consider 2 cases below
                 * the i'th stone is not considered in which case weight = dp[i-1][j]
                 * the i'th stone is considered in which case weight = dp[i-1][j-stones[i-1]] + stones[i-1]
                 *
                 * Note that we use stones [i-1] because [i-1] stands for ith weight
                 * While stone follows indexing from 0 onwards
                 * The dp array does not
                 */


                if (stones[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int maxSumPossibleForTheLowerHalf = dp[stones.length][desiredWeight];

        return sum - 2 * maxSumPossibleForTheLowerHalf;
    }
}
