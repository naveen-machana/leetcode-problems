package com.naveen.problems.misc;

class Problem1672_MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int max = sum(accounts[0]);
        for (int i = 1; i < accounts.length; i++) {
            int sum = sum(accounts[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public int sum(int[] row) {
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }
        return sum;
    }
}
