package com.naveen.problems.heaps;


import java.util.PriorityQueue;

/*
https://leetcode.com/problems/sliding-window-maximum/
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of
the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right
by one position.

Return the max sliding window.

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

* */
public class Problem239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length, rp = 0;
        int[] res = new int[n - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o, t) -> a[t] - a[o]);
        for (int i = 0; i < k; i++) pq.offer(i);
        for (int i = k; i < n; i++) {
            res[rp++] = a[pq.peek()];
            pq.remove(i - k);
            pq.offer(i);
        }
        res[rp++] = a[pq.peek()];
        return res;
    }
}
