package com.naveen.problems.arrays.problem128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
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
