package com.naveen.problems.heaps;

import java.util.PriorityQueue;

/*
* https://leetcode.com/problems/k-closest-points-to-origin/
* Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
* return the k closest points to the origin (0, 0). The distance between two points on the X-Y plane is the Euclidean
* distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
* You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
* */
public class Problem973_KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> Double.compare(distance(p1), distance(p2)));
        for (int[] p : points) pq.offer(p);
        int[][] res = new int[k][2];
        while (k-- > 0) res[k] = pq.poll();
        return res;
    }

    private double distance(int[] p) {
        return Math.sqrt(p[0] * p[0] + p[1] * p[1]);
    }
}
