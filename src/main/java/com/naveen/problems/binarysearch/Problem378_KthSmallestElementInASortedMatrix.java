package com.naveen.problems.binarysearch;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element
in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
* */
public class Problem378_KthSmallestElementInASortedMatrix {

    private static class Tuple implements Comparable<Tuple> {
        int val, row, col;
        public Tuple(int val, int row, int col) { this.val = val; this.row = row; this.col = col; }
        public int compareTo(Tuple other) { return other.val - this.val; }
    }

    public int kthSmallest2(int[][] a, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) pq.offer(new Tuple(a[i][0], i, 0));
        for (int i = k; i > 0; i--) {
            Tuple t = pq.poll();
            if (t.col == a.length - 1) continue;
            pq.offer(new Tuple(a[t.row][t.col + 1], t.row, t.col + 1));
        }
        return pq.poll().val;
    }

    public int kthSmallest(int[][] a, int k) {
        int n = a.length;
        int lo = a[0][0], hi = a[n - 1][n - 1] + 1;

        while (lo < hi) {
            int mid = (lo + hi)/2;
            int count = 0;
            for (int i = 0, j = n - 1; i < n; i++) {
                while (j >= 0 && a[i][j] > mid) j--;
                count += (j + 1);
            }
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
