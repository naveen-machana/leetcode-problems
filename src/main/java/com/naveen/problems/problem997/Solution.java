package com.naveen.problems.problem997;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-town-judge/
public class Solution {
    //https://leetcode.com/problems/find-the-town-judge/solutions/242938/java-c-python-directed-graph/?orderBy=most_votes
    public int findJudgeOptimal(int n, int[][] trust) {
        int[] count = new int[n + 1];
        for (int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (count[i] == n -1)
                return i;
        }
        return -1;
    }
    public int findJudge(int n, int[][] trust) {
        boolean[][] trustGraph = new boolean[n + 1][n + 1];

        for (int[] cur : trust) {
            int a = cur[0];
            int b = cur[1];
            trustGraph[a][b] = true;
        }

        int st = 1, end = n;

        while (st < end) {
            if (trustGraph[st][end]) st++;
            else end--;
        }
        int candidate = st;

        for (int i = 1; i <= n; i++) {
            if (i != candidate && !trustGraph[i][candidate]) {
                return -1;
            }
            if (i != candidate && trustGraph[candidate][i]) {
                return -1;
            }
        }

        return candidate;
    }
}
