package com.naveen.problems.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/basic-calculator-ii/
// Given a string s which represents an expression, evaluate this expression and return its value.
//
// The integer division should truncate toward zero.
//
// You may assume that the given expression is always valid. All intermediate results will be in
// the range of [-231, 231 - 1].
//
// Note: You are not allowed to use any built-in function which evaluates strings as mathematical
// expressions, such as eval().
public class Problem227_BasicCalculator {
    public static void main(String[] args) {
        Problem227_BasicCalculator sol = new Problem227_BasicCalculator();
        System.out.println(sol.calculate("3+2*2 - 5 - 53 * 2"));
    }
    public int calculate(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char prevsign = '+';
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(c[i])) num = num * 10 + c[i] - '0';
            if ((!Character.isDigit(c[i]) && c[i] != ' ') || i == n - 1) {
                if (prevsign == '+') stack.push(num);
                if (prevsign == '-') stack.push(-num);
                if (prevsign == '*') stack.push(stack.pop() * num);
                if (prevsign == '/') stack.push(stack.pop() / num);
                prevsign = c[i];
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
