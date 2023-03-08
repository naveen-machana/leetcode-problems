package com.naveen.problems.arrays;

/*
* https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
* Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive.
* Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the
* repeating and missing numbers A and B where A repeats twice and B is missing.
*
* Input Format:  array[] = {3,1,2,5,3}

    Result: {3,4)

Explanation: A = 3 , B = 4
Since 3 is appearing twice and 4 is missing
* */
public class RepeatAndMissingNumberArray {
    public int[] repeatedNumber(int[] a) {
        int sum = 0, n = a.length;
        for (int i = 1; i <= n; i++ ) sum ^= i;
        for (int i = 0; i < n; i++) sum ^= a[i];

        int lastSetBit = sum & ~(sum - 1);
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if ((lastSetBit & a[i]) == 0) x ^= a[i];
            else y ^= a[i];

            if ((lastSetBit & (i + 1)) == 0) x ^= (i + 1);
            else y ^= (i + 1);
        }

        return new int[]{x, y};
    }
}
