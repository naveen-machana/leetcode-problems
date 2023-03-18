package com.naveen.problems.arrays;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/longest-harmonious-subsequence/
* We define a harmonious array as an array where the difference between its maximum value and its
* minimum value is exactly 1. Given an integer array nums, return the length of its longest harmonious
* subsequence among all its possible subsequences. A subsequence of array is a sequence that can be derived from the
* array by deleting some or no elements without changing the order of the remaining elements.
* Input: nums = [1,3,2,2,5,2,3,7]
* Output: 5
* Explanation: The longest harmonious subsequence is [3,2,2,2,3].
* https://leetcode.com/problems/longest-harmonious-subsequence/editorial/
* */

public class Problem594_LongestHarmoniousSubsequence {
    public int findLHS(int[] a) {
        Map<Integer, Integer> f = new HashMap<>();
        for (int n : a) f.merge(n, 1, (p, c) -> p + c);
        int max = 0;
        for (int x : f.keySet())
            if (f.containsKey(x - 1))
                max = Math.max(max, f.get(x - 1) + f.get(x));

        return max;
    }

    // subsequences - generate all subsequences, and find min & max values in a subsequence, check if diff between
    // min and max is 1
    public int findLHS2(int[] a) {
        int res = 0;
        for (int i = 0; i < (1 << a.length); i++) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, count = 0;
            for (int j = 0; j < a.length; j++) {
                if ((i & (1 << j)) == 1) {
                    min = Math.min(min, a[j]);
                    max = Math.max(max, a[j]);
                    count++;
                }
            }

            if (max - min == 1) res = Math.max(res, count);
        }
        return res;
    }
}
