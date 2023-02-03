package com.naveen.problems.arrays.problem287;

// https://leetcode.com/problems/find-the-duplicate-number/
// 287. Find the Duplicate Number
// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
// There is only one repeated number in nums, return this repeated number.
//
// You must solve the problem without modifying the array nums and uses only constant extra space
public class Solution {
    // 1. if modifications are allowed
    public int findDuplicate3(int[] a) {
        while(a[0] != a[a[0]]) {
            int next = a[0];
            a[0] = a[a[0]];
            a[a[0]] = next;
        }
        return a[0];
    }

    // 2. if modification is allowed
    // below logic can be used for 41. first missing positive
    // [1,3,3,2] => [1,−3,3,2] => [1,−3,3,−2] => found the duplicate
    public int findDuplicate2(int[] a) {
        int duplicate = -1;

        for (int i = 0; i < a.length; i++) {
            int cur = Math.abs(a[i]);
            if (a[cur] < 0) {
                duplicate = cur;
                break;
            }
            else {
                a[cur] *= -1;
            }
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = Math.abs(a[i]);
        }

        return duplicate;
    }

    // 3. tortoise and hare solution
    // a cycle definitely exists based on pigeonhole principle
    // find the starting point of cycle
    public int findDuplicate1(int[] a) {
        int tortoise = a[0];
        int hare = a[0];

        do {
            tortoise = a[tortoise];
            hare = a[a[hare]];
        } while (tortoise != hare);

        tortoise = a[0];
        while (tortoise != hare) {
            tortoise = a[tortoise];
            hare = a[hare];
        }
        return tortoise;
    }

    public int findDuplicate(int[] a) {
        int st = 1, end = a.length - 1;
        int duplicate = -1;
        while (st <= end) {
            int cur = (st + end)/ 2;

            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= cur) count++;
            }

            if (count > cur) {
                duplicate = cur;
                end = cur - 1;
            }
            else {
                st = cur + 1;
            }
        }
        return duplicate;
    }

}
