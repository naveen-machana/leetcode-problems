package com.naveen.blind75.arrays;

import java.util.HashMap;
import java.util.Map;

public class Problem1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int req = target - nums[i];
            if (indices.get(req) != null) {
                return new int[]{i, indices.get(req)};
            }
            indices.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
