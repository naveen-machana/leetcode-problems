package com.naveen.problems.heaps;

import java.util.PriorityQueue;

/*
* https://leetcode.com/problems/kth-largest-element-in-a-stream/
* Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted
* order, not the kth distinct element. Implement KthLargest class:
* KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
* int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element
* in the stream.
* Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
* */
public class Problem703_KthLargestElementInAStream {
    public static class KthLargest {
        PriorityQueue<Integer> pq;
        int capacity;
        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>(k);
            capacity = k;
            for (int n : nums) add(n);
        }

        public int add(int val) {
            if (pq.size() < capacity) pq.offer(val);
            else if (pq.peek() < val) {
                pq.poll();
                pq.offer(val);
            }
            return pq.peek();
        }
    }
}
