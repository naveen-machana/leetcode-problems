package com.naveen.problems.misc;

public class Problem896_MonotonicArray {
    public boolean isMonotonic(int[] a) {
        int i = 1, n = a.length;
        while (i < n && a[i] == a[i - 1]) i++;
        boolean increasing = i < n && a[i] > a[i - 1];
        while (i < n) {
            if (a[i] != a[i - 1]) {
                boolean sign = a[i] > a[i - 1];
                if (sign != increasing) return false;
            }
            i++;
        }
        return true;
    }
}
