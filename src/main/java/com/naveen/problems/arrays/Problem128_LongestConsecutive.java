package com.naveen.problems.arrays;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/longest-consecutive-sequence/
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
* */
public class Problem128_LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxCount = 0;

        for (int i : nums) set.add(i);
        for (int i : nums) {
            int count = 1;
            if (!set.contains(i - 1)) {
                while (set.contains(i + 1)) {
                    count++;
                    i++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
