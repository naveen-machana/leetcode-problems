package com.naveen.problems.problem1342;

class Solution {
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