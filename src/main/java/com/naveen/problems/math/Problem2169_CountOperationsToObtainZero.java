package com.naveen.problems.math;

// https://leetcode.com/problems/count-operations-to-obtain-zero/
class Problem2169_CountOperationsToObtainZero {
    public int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) num1 = num1 - num2;
            else num2 = num2 - num1;
            count++;
        }
        return count;
    }
}
