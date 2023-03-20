package com.naveen.problems.math;

/*
* https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
* */
class Problem1342_NumberOfSteps {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 0) num = num/2;
            else num--;
            count++;
        }
        return count;
    }
}