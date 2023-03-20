package com.naveen.problems.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
* https://leetcode.com/problems/delete-and-earn
* You are given an integer array nums. You want to maximize the number of points you get by performing the following
* operation any number of times:
* Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1
* and every element equal to nums[i] + 1.
* Return the maximum number of points you can earn by applying the above operation some number of times.
* Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.
* */
public class Problem740_DeleteAndEarn {
    public int deleteAndEarn(int[] a) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int n : a) map.merge(n, 1, (p, c) -> p + c);
        int[] sorted = new int[map.size()]; int i = 0;
        for (int k : map.keySet()) sorted[i++] = k;

        int earn1 = 0, earn2 = 0;
        for (i = 0; i < sorted.length; i++) {
            int curEarn = sorted[i] * map.get(sorted[i]);
            int temp = earn2;
            earn2 = i > 0 && sorted[i] == sorted[i - 1] + 1 ? Math.max(curEarn + earn1, earn2) : curEarn + earn2;
            earn1 = temp;
        }
        return earn2;
    }
}
