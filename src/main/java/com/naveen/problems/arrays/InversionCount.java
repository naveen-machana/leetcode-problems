package com.naveen.problems.arrays;

public class InversionCount {
    static long inversionCount(long a[], long n)
    {
        return count(a, 0, (int)n - 1);
    }

    static long count(long[] a, int st, int end) {
        long res = 0;
        if (st < end) {
            int mid = (st + end)/2;
            long l = count(a, st, mid);
            long r = count(a, mid + 1, end);
            long m = merge(a, st, mid, end);
            res = l + r + m;
        }
        return res;
    }

    static long merge(long[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        long[] left = new long[n1];
        long[] right = new long[n2];

        for (int i = 0; i < n1; i++) left[i] = a[i + l];
        for (int i = 0; i < n2; i++) right[i] = a[i + m + 1];

        int i = 0, j = 0, k = l;
        long count = 0;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            }
            else {
                count += (n1 - i);
                a[k++] = right[j++];
            }
        }

        while (i < n1) a[k++] = left[i++];
        while (j < n2) a[k++] = right[j++];

        return count;
    }
}
