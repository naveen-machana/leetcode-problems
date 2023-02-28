package com.naveen.problems.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* You are given a sorted unique integer array nums.
A range [a,b] is the set of all integers from a to b (inclusive).
Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
* That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is
*  in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
* */
public class Problem228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        // though the solution works, this solution did not take the fact into consideration that the array is already
        // sorted. So there is scope for improvement.
        List<String> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE || !set.contains(nums[i] - 1)) {
                StringBuilder pair = new StringBuilder();
                pair.append(nums[i]);
                int x = nums[i];
                while (x != Integer.MAX_VALUE && set.contains(x + 1)) x = x + 1;
                if (x != nums[i]) pair.append("->" + x);
                res.add(pair.toString());
            }
        }
        return res;
    }
}
