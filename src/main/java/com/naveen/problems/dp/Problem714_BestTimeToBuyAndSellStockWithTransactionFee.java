package com.naveen.problems.dp;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
* You are given an array prices where prices[i] is the price of a given stock on the ith day,
* and an integer fee representing a transaction fee.
* Find the maximum profit you can achieve. You may complete as many transactions as you like,
* but you need to pay the transaction fee for each transaction.
* Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
* Input: prices = [1,3,2,8,4,9], fee = 2
* Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
* */
public class Problem714_BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        Map<String, Integer> map = new HashMap<>();
        return maxProfit(prices, 0, prices.length, map, fee, true);
    }

    private int maxProfit(int[] a, int i, int n, Map<String, Integer> map, int fee, boolean isBuying) {
        if (i == n) return 0;
        String mkey = i + ":" + isBuying;
        if (map.containsKey(mkey)) return map.get(mkey);
        int cooldown = maxProfit(a, i + 1, n, map, fee, isBuying);
        if (isBuying) {
            int buying = maxProfit(a, i + 1, n, map, fee, !isBuying) - a[i];
            map.put(mkey, Math.max(buying, cooldown));
        }
        else {
            int selling = maxProfit(a, i + 1, n, map, fee, !isBuying) + a[i] - fee;
            map.put(mkey, Math.max(selling, cooldown));
        }
        return map.get(mkey);
    }
}
