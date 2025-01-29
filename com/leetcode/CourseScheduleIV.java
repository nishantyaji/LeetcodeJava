package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// Problem 1462
public class CourseScheduleIV {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        boolean [][] dp = new boolean[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            dp[prerequisite[0]][prerequisite[1]] = true;
        }
        for(int k = 0; k < numCourses; k++) {
            for(int i = 0; i < numCourses; i++) {
                for(int j = 0; j < numCourses; j++) {
                    dp[i][j] = dp[i][j] || (dp[i][k] && dp[k][j]);
                }
            }
        }
        for (int[] query : queries) {
            res.add(dp[query[0]][query[1]]);
        }
        return res;
    }
}
