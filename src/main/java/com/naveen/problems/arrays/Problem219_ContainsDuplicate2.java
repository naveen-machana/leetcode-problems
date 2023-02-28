package com.naveen.problems.arrays;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/contains-duplicate-ii/
* Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
* such that nums[i] == nums[j] and abs(i - j) <= k.
*
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Input: nums = [1,0,1,1], k = 1
Output: true
*
* */
public class Problem219_ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i]) && Math.abs(i - map.get(a[i])) <= k) return true;
            map.put(a[i], i);
        }
        return false;
    }
}
