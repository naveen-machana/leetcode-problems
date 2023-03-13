package com.naveen.problems.graphs;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/flower-planting-with-no-adjacent/
// 1042. Flower Planting With No Adjacent
// You have n gardens, labeled from 1 to n, and an array paths where paths[i] = [xi, yi] describes a bidirectional
// path between garden xi to garden yi. In each garden, you want to plant one of 4 types of flowers.
//
//All gardens have at most 3 paths coming into or leaving it.
//
//Your task is to choose a flower type for each garden such that, for any two gardens connected by a path,
// they have different types of flowers.
//
//Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)th garden.
// The flower types are denoted 1, 2, 3, or 4. It is guaranteed an answer exists.
public class Problem1042_FlowPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] p : paths) {
            g.get(p[0] - 1).add(p[1] - 1);
            g.get(p[1] - 1).add(p[0] - 1);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] taken = new boolean[5];
            for (int adj : g.get(i)) taken[res[adj]] = true;
            for (int j = 1; j < 5; j++)
                if (!taken[j]) res[i] = j;
        }
        return res;
    }
}
