package com.naveen.problems.arrays;

public class Problem896_MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        boolean incr = true, decr = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) incr = false;
            if (nums[i - 1] < nums[i]) decr = false;
        }
        return incr || decr;
    }
}
