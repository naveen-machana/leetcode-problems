package com.naveen.problems.arrays;

/*
* https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
* Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
* find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and
* numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.
*
* Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
* */
public class Problem167_TwoSumII_InputArrayIsSorted {
    // approach - 2
    public int[] twoSum2(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int sum = a[l] + a[r];
            if (sum == target) return new int[]{l + 1, r + 1};
            else if (sum > target) r--;
            else l++;
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum(int[] a, int target) {
        for (int i = 0; i < a.length - 1; i++) {
            int l = i + 1, r = a.length - 1;
            while (l <= r) {
                int m = (l + r)/2;
                if (a[m] == target - a[i]) return new int[]{i + 1, m + 1};
                else if (a[m] > target - a[i]) r = m - 1;
                else l = m + 1;
            }
        }

        return new int[]{-1, -1};
    }
}
