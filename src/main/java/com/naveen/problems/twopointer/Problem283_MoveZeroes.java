package com.naveen.problems.twopointer;

public class Problem283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int st = -1, cur = 0;
        while (cur < nums.length) {
            if (nums[cur] != 0) {
                st ++;
                int x = nums[st];
                nums[st] = nums[cur];
                nums[cur] = x;
            }
            cur ++;
        }
    }
}
