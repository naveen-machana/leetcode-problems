package com.naveen.problems.arrays;

import java.util.HashSet;
import java.util.Set;

/*
* https://leetcode.com/problems/contains-duplicate/description/
* Given an integer array nums, return true if any value appears at least twice in the array, and return false if every
* element is distinct.
*
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

* */
public class Problem217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) return true;
        }
        return false;
    }
}
