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
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        sum(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void sum(int[] a, int remain, int st, List<List<Integer>> res, List<Integer> temp) {
        if (remain < 0) return;
        else if (remain == 0) { res.add(new ArrayList<>(temp)); return; }
        else {
            for (int i = st; i< a.length; i++) {
                if (i > st && a[i] == a[i - 1]) continue;
                temp.add(a[i]);
                sum(a, remain - a[i], i + 1, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
