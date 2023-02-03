package com.naveen.problems.arrays;

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
        }
        return new int[]{x ^ sum, y ^ sum};
    }
}
