package com.naveen.problems.arrays;

import java.util.*;

// https://leetcode.com/problems/4sum/
// 18. 4Sum
// Given an array nums of n integers, return an array of all the unique quadruplets
// [nums[a], nums[b], nums[c], nums[d]] such that:
//
// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
public class Problem18_4Sum_KSum {
    public static void main(String[] args) {
        Problem18_4Sum_KSum sol = new Problem18_4Sum_KSum();
        int[] a = {2,2,2,2,2};
        sol.fourSum(a, 8);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length) return res;
        if (k == 2) return twoSum(nums, target, start);
        for (int i = start; i < nums.length - (k - 1); i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            for (List<Integer> entry : kSum(nums, target - nums[i], i + 1, k - 1)) {
                List<Integer> cur = new ArrayList();
                cur.add(nums[i]);
                cur.addAll(entry);
                res.add(cur);
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            // Please note that if we use the below stmt, then 2 sum wont work for avoiding duplicates
            // if (i > start && nums[i] == nums[i - 1]) continue; -- wont work
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
                if (set.contains(target - nums[i])) res.add(new ArrayList(List.of(target - nums[i], nums[i])));
            }
            set.add((long)nums[i]);
        }
        return res;
    }
}
