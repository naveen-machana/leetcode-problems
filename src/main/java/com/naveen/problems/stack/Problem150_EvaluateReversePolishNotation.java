package com.naveen.problems.stack;

import java.util.ArrayDeque;
import java.util.Set;

/*
* https://leetcode.com/problems/evaluate-reverse-polish-notation/
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
* */
public class Problem150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Set<String> operators = Set.of("+", "-", "/", "*");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (operators.contains(tokens[i])) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int res = 0;
                switch (tokens[i]) {
                    case "+" : res = (op1 + op2); break;
                    case "-" : res = (op1 - op2); break;
                    case "*" : res = (op1 * op2); break;
                    case "/" : res = (op1 / op2); break;
                }
                stack.push(res);
            }
            else stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.pop();
    }
}
