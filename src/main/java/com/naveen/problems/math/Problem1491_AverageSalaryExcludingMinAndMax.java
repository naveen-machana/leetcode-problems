package com.naveen.problems.math;

// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description
// You are given an array of unique integers salary where salary[i] is the salary of the ith employee.
//
//Return the average salary of employees excluding the minimum and maximum salary.
// Answers within 10-5 of the actual answer will be accepted.
public class Problem1491_AverageSalaryExcludingMinAndMax {
    public double average(int[] salary) {
        int min = salary[0], max = salary[0], sum = 0;
        for (int i = 0; i < salary.length; i++) {
            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
            sum += salary[i];
        }
        sum -= (min + max);
        return ((double)sum) / (salary.length - 2);
    }
}
