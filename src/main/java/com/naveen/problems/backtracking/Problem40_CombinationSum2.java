package com.naveen.problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum-ii/
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
Input: candidates = [10,1,2,7,6,1,5], target = 8
1,1,2,5,6,7,10

Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
* */
public class Problem40_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(candidates, res, new ArrayList<>(), 0, target);
        return res;
    }

    private void combinationSum(int[] candidates, List<List<Integer>> res, List<Integer> cur, int i, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        else if (i >= candidates.length || target < 0) return;
        else {
            cur.add(candidates[i]);
            combinationSum(candidates, res, cur, i + 1, target - candidates[i]);
            cur.remove(cur.size() - 1);
            int j = i + 1;
            while (j < candidates.length && candidates[j] == candidates[j - 1]) j++;
            combinationSum(candidates, res, cur, j, target);
        }
    }
}
