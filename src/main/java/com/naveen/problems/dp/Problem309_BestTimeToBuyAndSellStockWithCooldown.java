package com.naveen.problems.dp;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
* You are given an array prices where prices[i] is the price of a given stock on the ith day.
* Find the maximum profit you can achieve. You may complete as many transactions as you like
* (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*
*Input: prices = [1,2,3,0,2]
* Output: 3
* Explanation: transactions = [buy, sell, cooldown, buy, sell]
* */
public class Problem309_BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        Map<String, Integer> map = new HashMap<>();
        return maxProfit(prices, 0, prices.length, true, map);
    }

    private int maxProfit(int[] a, int i, int n, boolean isBuying, Map<String, Integer> map) {
        if (i >= n) return 0;
        String mkey = i + ":" + isBuying;
        if (map.containsKey(mkey)) return map.get(mkey);
        int cooldown = maxProfit(a, i + 1, n, isBuying, map);
        if (isBuying) {
            int buying = maxProfit(a, i + 1 , n, !isBuying, map) - a[i];
            map.put(mkey, Math.max(buying, cooldown));
        }
        else {
            int selling = maxProfit(a, i + 2, n, !isBuying, map) + a[i];
            map.put(mkey, Math.max(selling, cooldown));
        }
        return map.get(mkey);
    }
}
