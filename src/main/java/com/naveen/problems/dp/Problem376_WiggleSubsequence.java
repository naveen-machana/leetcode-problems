package com.naveen.problems.dp;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/wiggle-subsequence
* A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive
* and negative. The first difference (if one exists) may be either positive or negative. A sequence with one element
* and a sequence with two non-equal elements are trivially wiggle sequences.
* For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate between
* positive and negative. In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences.
* The first is not because its first two differences are positive, and the second is not because its last difference is
*  zero. A subsequence is obtained by deleting some elements (possibly zero) from the original sequence,
* leaving the remaining elements in their original order. Given an integer array nums, return the length of the longest
* wiggle subsequence of nums.
* Input: nums = [1,17,5,10,13,15,10,5,16,8]
* Output: 7
* Explanation: There are several subsequences that achieve this length.
* One is [1, 17, 10, 13, 10, 16, 8] with differences (16, -7, 3, -3, 6, -8).
*
* */
public class Problem376_WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        Map<String, Integer> dp = new HashMap<>();
        return Math.max(length(nums, 0, nums.length, dp, true), length(nums, 0, nums.length, dp, false));
    }

    private int length(int[] a, int i, int n, Map<String, Integer> dp, boolean isPositive) {
        if (i >= n) return 0;
        if (i == n - 1) return 1;
        String key = i + ":" + isPositive;
        if (dp.containsKey(key)) return dp.get(key);
        int ignored = length(a, i + 1, n, dp, isPositive);
        if (isPositive) {
            int res = 0;
            for (int j = i + 1; j < n; j++) {
                int subres = 0;
                if (a[j] - a[i] > 0) {
                    subres = 1 + length(a, j, n, dp, !isPositive);
                }
                res = Math.max(res, subres);
            }
            dp.put(key, Math.max(ignored, res));
        }
        else {
            int res = 0;
            for (int j = i + 1; j < n; j++) {
                int subres = 0;
                if (a[j] - a[i] < 0) {
                    subres = 1 + length(a, j, n, dp, !isPositive);
                }
                res = Math.max(res, subres);
            }
            dp.put(key, Math.max(ignored, res));
        }
        return dp.get(key);
    }
}
