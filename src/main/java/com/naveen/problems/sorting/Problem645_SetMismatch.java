package com.naveen.problems.sorting;

/*
* https://leetcode.com/problems/set-mismatch/
* You have a set of integers s, which originally contains all the numbers from 1 to n.
* Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
* which results in repetition of one number and loss of another number.
* You are given an integer array nums representing the data status of this set after the error.
* Find the number that occurs twice and the number that is missing and return them in the form of an array.
* */
public class Problem645_SetMismatch {
    public int[] findErrorNums(int[] a) {
        int xor = 0, n = a.length;
        for (int i = 1; i <= n; i++) xor ^= i;
        for (int i = 0; i < n; i++) xor ^= a[i];
        int lastSetBit = xor & ~(xor - 1);
        int x = 0, y = 0;
        for (int i = 1; i <= n; i++) {
            if ((lastSetBit & i) != 0) x ^= i;
            else y ^= i;
        }
        for (int i = 0; i < n; i++) {
            if ((lastSetBit & a[i]) != 0) x ^= a[i];
            else y ^= a[i];
        }
        for (int i = 0; i < n; i++)
            if (a[i] == x)
                return new int[]{x, y};

        return new int[]{y, x};
    }
}
