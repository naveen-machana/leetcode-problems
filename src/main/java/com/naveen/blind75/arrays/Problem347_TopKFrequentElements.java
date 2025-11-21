package com.naveen.blind75.arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) counter.merge(n, 1, (ov, nv) -> ov + nv);
        PriorityQueue<Entry> q = new PriorityQueue<>(Collections.reverseOrder());
        for (var entry : counter.entrySet()) q.offer(new Entry(entry.getKey(), entry.getValue()));
        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = q.poll().k;
        }
        return results;
    }

    private class Entry implements Comparable<Entry> {
        private int k, v;
        public Entry(int k, int v) {
            this.k = k;
            this.v = v;
        }
        public int compareTo(Entry other) {
            return Integer.valueOf(v).compareTo(Integer.valueOf(other.v));
        }
    }
}
