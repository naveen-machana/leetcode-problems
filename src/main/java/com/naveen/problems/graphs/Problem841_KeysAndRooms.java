package com.naveen.problems.graphs;

import java.util.List;

// https://leetcode.com/problems/keys-and-rooms/
// 841. Keys and Rooms
// There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
// Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
//
//When you visit a room, you may find a set of distinct keys in it. Each key has a number on it,
// denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
//
//Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
// return true if you can visit all the rooms, or false otherwise.
public class Problem841_KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> g) {
        int n = g.size();
        boolean[] visited = new boolean[n];
        dfs(g, visited, 0);
        boolean allVisited = true;
        for (boolean cur : visited) allVisited &= cur;
        return allVisited;
    }

    void dfs(List<List<Integer>> g, boolean[] visited, int src) {
        visited[src] = true;
        for (int adj : g.get(src)) {
            if (!visited[adj])
                dfs(g, visited, adj);
        }
    }
}
