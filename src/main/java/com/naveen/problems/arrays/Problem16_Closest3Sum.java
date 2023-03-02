package com.naveen.problems.arrays;

/*
https://leetcode.com/problems/3sum-closest/
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is
closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
* */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem16_Closest3Sum {
    public int threeSumClosest(int[] a, int target) {
        if (a.length  < 3) return 0;
        int closest = a[0] + a[1] + a[2];
        Arrays.sort(a);
        for (int i = 0; i < a.length - 2; i++) {
            if (i != 0 && a[i - 1] == a[i]) continue;
            int j = i + 1, k = a.length - 1;
            while (j < k) {
                int cur = a[i] + a[j] + a[k];
                if (cur == target) return cur;
                if (Math.abs(target - cur) < Math.abs(target - closest)) closest = cur;
                if (cur > target) k--;
                else j++;
            }
        }
        return closest;
    }
}
