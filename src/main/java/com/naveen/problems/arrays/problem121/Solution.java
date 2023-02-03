package com.naveen.problems.arrays.problem121;

import java.util.ArrayDeque;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// 121. Best Time to Buy and Sell Stock
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different
// day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
public class Solution {
    public int maxProfit(int[] a) {
        if (a.length <= 1) return 0;
        int minEle = a[0], max = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] <= minEle) minEle = a[i];
            else max = Math.max(max, a[i] - minEle);
        }
        return max;
    }
}
