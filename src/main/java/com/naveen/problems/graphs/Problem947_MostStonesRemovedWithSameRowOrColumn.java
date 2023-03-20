package com.naveen.problems.graphs;

import java.util.*;

// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
// On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
//
//A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
//
//Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone,
// return the largest possible number of stones that can be removed.

// NOTE: something is not correct
public class Problem947_MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int count = 0;
        for (int[] e : stones) {
            if (!visited.contains(e)) {
                count++;
                dfs(stones, visited, e);
            }
        }
        return stones.length - count;
    }

    public void dfs(int[][] stones, Set<int[]> visited, int[] cur) {
        visited.add(cur);
        for (int[] next : stones)
            if (!visited.contains(next))
                if (next[0] == cur[0] || next[1] == cur[1])
                    dfs(stones, visited, next);
    }
}
