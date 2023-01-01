package com.naveen.problems.problem1337;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Optimized {
    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Counter> pq = new PriorityQueue<>(k);

        for (int i = 0; i < mat.length; i++) {
            Counter c = new Counter(i);
            c.count = numOnes(mat[i]);
            pq.offer(c);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = pq.poll().rowIndex;

        return res;
    }

    private static int numOnes(int[] row) {
        int l = 0, h = row.length;

        while (l < h) {
            int m = (l + h)/2;
            if (row[m] == 1) l = m + 1;
            else h = m;
        }
        return l;
    }

    private static class Counter implements Comparable<Counter> {
        int count;
        int rowIndex;
        public Counter(int rowIndex) {
            this.rowIndex = rowIndex;
        }

        @Override
        public int compareTo(Counter o) {
            if (this.count != o.count) {
                return count - o.count;
            }
            return rowIndex - o.rowIndex;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1,1,1,1},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,0},{1,1,1,1,1}};
        System.out.println(Arrays.toString(kWeakestRows(mat, 3)));
    }
}
