package com.naveen.problems.misc;

class Problem1672_MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int cur = 0, max = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) cur += accounts[i][j];
            max = Math.max(cur, max); cur = 0;
        }
        return max;
    }
}
