package com.naveen.problems.heaps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/top-k-frequent-elements/
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
* */
public class Problem347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            int c = counter.getOrDefault(n, 0);
            counter.put(n, c + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o, t) -> counter.get(o) - counter.get(t));
        Iterator<Integer> iterator = counter.keySet().iterator();
        for (int i = 0; i <k; i++) pq.offer(iterator.next());

        while(iterator.hasNext()) {
            int ele = iterator.next();
            if (counter.get(pq.peek()) < counter.get(ele)) {
                pq.poll();
                pq.offer(ele);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = pq.poll();
        return res;
    }
}
