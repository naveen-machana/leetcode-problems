package com.naveen.problems.twopointer;

import java.util.Arrays;

public class Problem1984_MinDiffBtnHighestLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = k - 1, res = Integer.MAX_VALUE;
        while (j < nums.length) {
            res = Math.min(res, nums[j] - nums[i]);
            i++; j++;
        }
        return res;
    }
}
