package com.naveen.problems.problem1791;

// https://leetcode.com/problems/find-center-of-star-graph/
public class Solution {

    // https://leetcode.com/problems/find-center-of-star-graph/solutions/1108319/o-1-1-liner/?orderBy=most_votes
    public int findCenterOptimal(int[][] e) {
        return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
    }

    public int findCenter(int[][] edges) {

        int maxvertex = 1;
        for (int[] edge : edges) {
            maxvertex = Math.max(edge[0], maxvertex);
            maxvertex = Math.max(edge[1], maxvertex);
        }

        int[] count = new int[maxvertex + 1];
        for (int[] edge : edges) {
            ++count[edge[0]];
            ++count[edge[1]];
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] == maxvertex - 1)
                return i;
        }
        return -1;
    }
}
