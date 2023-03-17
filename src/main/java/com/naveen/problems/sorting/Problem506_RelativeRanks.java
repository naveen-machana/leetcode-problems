package com.naveen.problems.sorting;

import java.util.Arrays;

/*
* https://leetcode.com/problems/relative-ranks/
* You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition.
*  All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score,
* the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number
* (i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.

Example 1:

Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
* */
public class Problem506_RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++)
            a[i] = new int[]{score[i], i};
        Arrays.sort(a, (one, two) -> two[0] - one[0]);

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) res[a[i][1]] = "Gold Medal";
            else if (i == 1) res[a[i][1]] = "Silver Medal";
            else if (i == 2) res[a[i][1]] = "Bronze Medal";
            else res[a[i][1]] = (i + 1) + "";
        }
        return res;
    }
}
