package com.naveen.problems.binarysearch;

/*
* https://leetcode.com/problems/koko-eating-bananas/
* Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
* The guards have gone and will come back in h hours. Koko can decide her bananas-per-hour eating speed of k.
* Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas,
* she eats all of them instead and will not eat any more bananas during this hour. Koko likes to eat slowly but still
* wants to finish eating all the bananas before the guards return. Return the minimum integer k such that she can eat
* all the bananas within h hours.
* Input: piles = [3,6,7,11], h = 8 Output: 4
* */
public class Problem875_KokoEatingBananas {
    public int minEatingSpeed(int[] a, int h) {
        int max = a[0], n = a.length;
        for (int x : a) if (max < x) max = x;
        int l = 1, r = max;
        while (l < r) {
            int m = (l + r)/2;
            int sum = 0;
            for (int x : a) sum += x % m == 0 ? x / m : x / m + 1;
            if (sum > h) l = m + 1;
            else r = m;
        }
        return l;
    }
}
