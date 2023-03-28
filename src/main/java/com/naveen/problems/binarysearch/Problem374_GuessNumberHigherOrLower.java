package com.naveen.problems.binarysearch;

public class Problem374_GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int m = lo + (hi - lo)/2;
            int picked = guess(m);
            if (picked == 0) return m;
            else if (picked > 0) lo = m + 1;
            else hi = m - 1;
        }
        return -1;
    }
    private int guess(int m) {
        return m;
    }
}
