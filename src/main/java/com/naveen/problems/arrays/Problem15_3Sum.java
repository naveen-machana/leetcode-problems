package com.naveen.problems.arrays;

import java.util.*;

// https://leetcode.com/problems/3sum/description/
// 15. 3Sum
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
// Notice that the solution set must not contain duplicate triplets.
public class Problem15_3Sum {
    public List<List<Integer>> threeSum(int[] a) {
        Set<List<Integer>> res = new HashSet<>();
        int n = a.length;
        if (n < 3) return new ArrayList<>(res);
        Arrays.sort(a);
        int i = 0, j, k;
        for (; i < n - 2; i++) {
            j = i + 1; k = n - 1;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum == 0) {
                    res.add(Arrays.asList(a[i], a[j++], a[k--]));
                }
                else if (sum > 0) k--;
                else j++;
            }
        }
        return new ArrayList<>(res);
    }
}
