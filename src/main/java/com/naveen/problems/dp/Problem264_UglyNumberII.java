package com.naveen.problems.dp;

import java.util.LinkedList;
import java.util.Queue;

/*
* https://leetcode.com/problems/ugly-number-ii
* An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return the nth ugly number.
* Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
* */
public class Problem264_UglyNumberII {
    public static void main(String[] args) {
        Problem264_UglyNumberII sol = new Problem264_UglyNumberII();
        System.out.println(sol.nthUglyNumber(1600));
    }
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        Queue<Long> q2 = new LinkedList<>();
        Queue<Long> q3 = new LinkedList<>();
        Queue<Long> q5 = new LinkedList<>();
        q2.offer(2l);
        q3.offer(3l);
        q5.offer(5l);
        n --;

        while (!q2.isEmpty() || !q3.isEmpty() || !q5.isEmpty()) {
            long min2 = q2.peek();
            long min3 = q3.peek();
            long min5 = q5.peek();
            if (n == 1) return (int)Math.min(min2, Math.min(min3, min5));
            if (min2 < min3 && min2 < min5) {
                q2.poll();
                q2.offer(2 * min2);
                q3.offer(3 * min2);
                q5.offer(5 * min2);
            }
            else if (min3 < min2 && min3 < min5) {
                q3.poll();
                q3.offer(3 * min3);
                q5.offer(5 * min3);
            }
            else {
                q5.poll();
                q5.offer(5 * min5);
            }
            n--;
        }
        throw new IllegalArgumentException("Should not reach here");
    }
}
