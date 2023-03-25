package com.naveen.problems.dp;

/*
* https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product
* Input: nums = [0,1,-2,-3,-4]
* Output: 3
* Explanation: The longest subarray with positive product is [1,-2,-3] which has a product of 6.
Notice that we cannot include 0 in the subarray since that'll make the product 0 which is not positive.
*
elements      :   9    5    8    2    -6    4    -3    0    2    -5    15    10    -7    9    -2
positive_len  :   1    2    3    4     0    1     7    0    1     0     1     2     5    6     5
negative_len  :   0    0    0    0     5    6     2    0    0     2     3     4     3    4     7
*
elements      :   1    2    3   -1    -2   -3     1    2    3
positive_len  :   1    2    3    0     5    2     3    4    5
negative_len  :   0    0    0    4     1    6     7    8    9

* */
public class Problem1567_MaximumLengthOfSubarrayWithPositiveProduct {
    public static void main(String[] args) {
        Problem1567_MaximumLengthOfSubarrayWithPositiveProduct sol = new Problem1567_MaximumLengthOfSubarrayWithPositiveProduct();
        int[] a = {-1,-2,-3,0,1};
        sol.getMaxLen(a);
    }
    public int getMaxLen2(int[] nums) {
        int pos = 0, neg = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                pos = 0;
                neg = 0;
            }
            else if (nums[i] > 0) {
                pos++;
                neg = neg == 0 ? 0 : neg + 1;
            }
            else {
                int temp = pos;
                pos = neg == 0 ? 0 : neg + 1;
                neg = temp + 1;
            }
            ans = Math.max(ans, pos);
        }
        return ans;
    }

    public int getMaxLen(int[] a) {
        int n = a.length, ans = 0;
        for (int i = 0; i < n;) {
            int st = i;
            while (st < n && a[st] == 0) st++;
            int end = st;
            int c = 0, sn = -1, en = -1;
            while (end < n && a[end] != 0) {
                if (a[end] < 0) {
                    c++;
                    if (sn == -1) sn = end;
                    en = end;
                }
                end++;
            }
            if (c % 2 == 0) ans = Math.max(ans, end - st);
            else {
                if (sn != -1) ans = Math.max(ans, end - 1 - sn);
                if (en != -1) ans = Math.max(ans, en - st);
            }
            i = end + 1;
        }
        return ans;
    }

}
