package com.naveen.problems.heaps;

import java.util.PriorityQueue;

public class Problem1337_KWeakestRowsInAMatrix {
    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < mat.length; i++) {
            int l = 0, r = mat[i].length;
            while (l < r) {
                int mid = (l + r)/2;
                if (mat[i][mid] == 1) l = mid  + 1;
                else r = mid;
            }
            pq.offer(new int[]{i, l});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = pq.poll()[0];
        return res;
    }
}
