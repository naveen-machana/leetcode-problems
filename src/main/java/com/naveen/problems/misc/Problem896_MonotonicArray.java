package com.naveen.problems.misc;

public class Problem896_MonotonicArray {
    public boolean isMonotonic(int[] a) {
        boolean inc = true, dec = true;
        for (int i = 1; i < a.length; i++) {
            inc &= (a[i] >= a[i - 1]);
            dec &= (a[i] <= a[i - 1]);
        }
        return inc || dec;
    }
}
