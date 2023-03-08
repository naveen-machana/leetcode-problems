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
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;
        Arrays.sort(a);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = a[l] + a[r] + a[i];
                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                    res.add(List.of(a[i], a[l], a[r]));
                    while (l < r && a[l] == res.get(res.size() - 1).get(1)) l++;
                    while (l < r && a[r] == res.get(res.size() - 1).get(2)) r--;
                }
            }
        }
        return res;
    }
}
