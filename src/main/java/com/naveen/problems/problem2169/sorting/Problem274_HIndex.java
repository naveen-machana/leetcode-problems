package com.naveen.problems.problem2169.sorting;

import java.util.Arrays;
import java.util.Collections;

/*
* https://leetcode.com/problems/h-index/
* Given an array of integers citations where citations[i] is the number of citations a researcher received for their
* ith paper, return compute the researcher's h-index.
* According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least
* h citations each, and the other n − h papers have no more than h citations each.
* If there are several possible values for h, the maximum one is taken as the h-index.
* Input: citations = [3,0,6,1,5]
* Output: 3
* Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received
* 3, 0, 6, 1, 5 citations respectively.
* Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

* find largest k such that k elements are larger than or equal to k.
* */
public class Problem274_HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int k = 0, res = 0;
        for (int i = citations.length - 1; i >= 0; i++) {
            k++;
            if (citations[i] >= k) res = Math.max(res, k);
        }
        return res;
    }
}
