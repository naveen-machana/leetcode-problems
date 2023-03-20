package com.naveen.problems.sorting;

import java.util.HashSet;
import java.util.Set;

/*
* https://leetcode.com/problems/fair-candy-swap/description/
* Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes
* where aliceSizes[i] is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number of
* candies of the jth box of candy that Bob has. Since they are friends, they would like to exchange one candy box each
* so that after the exchange, they both have the same total amount of candy. The total amount of candy a person has is
* the sum of the number of candies in each box they have. Return an integer array answer where answer[0] is the number
*  of candies in the box that Alice must exchange, and answer[1] is the number of candies in the box that Bob must
* exchange. If there are multiple answers, you may return any one of them. It is guaranteed that at least one answer
* exists.
* Input: aliceSizes = [1,1], bobSizes = [2,2]
* Output: [1,2]
*
* Example 2:
* Input: aliceSizes = [1,2], bobSizes = [2,3]
* Output: [1,2]
*
* Example 3:
Input: aliceSizes = [2], bobSizes = [1,3]
Output: [2,3]
*
* SA = sum of all candies alice has
* SB = sum of all candies bob has
* if alice exchanges x candies box, she expects y candies box in return, so
* sa - x + y = sb - y + x
* y = sb - y + x + x - sa
* 2y = sb - sa + 2x
* y = (sb - sa)/2 + x
* so if alice shares x candies box, she expects a y candy box such that y = (sb - sa)/2 + x
* */
public class Problem888_FairCandySwap {
    public int[] fairCandySwap(int[] a, int[] b) {
        int sa = 0, sb = 0;
        for (int x : a) sa += x;
        for (int y : b) sb += y;
        int delta = (sb - sa)/2;
        Set<Integer> bcandies = new HashSet<>();
        for (int x : b) bcandies.add(x);

        for (int x : a)
            if (bcandies.contains(x + delta))
                return new int[]{x, x + delta};

        throw new IllegalArgumentException();
    }
}
