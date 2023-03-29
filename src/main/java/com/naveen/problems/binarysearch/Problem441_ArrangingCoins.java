package com.naveen.problems.binarysearch;

/*
* https://leetcode.com/problems/arranging-coins
* https://leetcode.com/problems/arranging-coins/editorial/
* You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith
* row has exactly i coins. The last row of the staircase may be incomplete.
* Given the integer n, return the number of complete rows of the staircase you will build.
*
Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.
* */
public class Problem441_ArrangingCoins {
    public int arrangeCoins2(int n) {
        int res = 0;
        for (int i = 1; n > 0; i++) {
            if (n - i >= 0) {
                res++;
                n = n - i;
            }
            else return res;
        }
        return res;
    }

    // finding floor - largest K such that cur <= n
    public int arrangeCoins(int n) {
        long l = 1, r = n;
        long k, curr;
        while (l <= r) {
            k = l + (r - l)/2;
            curr = k * (k + 1)/2;

            if (curr == n) return (int)k;
            else if (curr > n) r = k - 1;
            else l = k + 1;
        }
        return (int)r;
    }
}
