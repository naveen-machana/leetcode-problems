package com.naveen.problems.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/different-ways-to-add-parentheses/description/
// Given a string expression of numbers and operators, return all possible results from computing all the different
// possible ways to group numbers and operators. You may return the answer in any order.
//
// The test cases are generated such that the output values fit in a 32-bit integer and the number of different
// results does not exceed 10^4
// Input: expression = "2*3-4*5"
// Output: [-34,-14,-10,-10,10]
// Explanation:
// (2*(3-(4*5))) = -34
// ((2*3)-(4*5)) = -14
// ((2*(3-4))*5) = -10
// (2*((3-4)*5)) = -10
// (((2*3)-4)*5) = 10
public class Problem241_DifferentWaysToGenerateParenthesis {
    private static final Set<Character> ops = Set.of('+', '-', '*', '/');

    public static void main(String[] args) {
        Problem241_DifferentWaysToGenerateParenthesis sol = new Problem241_DifferentWaysToGenerateParenthesis();
        List<String> sols = sol.diffWaysToCompute1("2*3-4*5");
        System.out.println(sols);
    }
    public List<String> diffWaysToCompute1(String expression) {
        return generate1(expression, 0);
    }

    private List<String> generate1(String exp, int ind) {
        List<String> res = new ArrayList<>();
        if (exp.length() == 1) {
            res.add(exp);
            return res;
        }

        for (int i = ind; i < exp.length(); i++) {
            if (ops.contains(exp.charAt(i))) {
                List<String> left = generate1(exp.substring(0, i), 0);
                List<String> right = generate1(exp.substring(i + 1), 0);
                for (String l : left) {
                    for (String r : right) {
                        res.add("(" + l + exp.charAt(i) + r + ")");
                    }
                }
            }
        }
        return res;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return generate(expression, 0);
    }

    private List<Integer> generate(String exp, int ind) {
        List<Integer> res = new ArrayList<>();

        for (int i = ind; i < exp.length(); i++) {
            if (ops.contains(exp.charAt(i))) {
                List<Integer> left = generate(exp.substring(0, i), 0);
                List<Integer> right = generate(exp.substring(i + 1), 0);
                for (int l : left) {
                    for (int r : right) {
                        if (exp.charAt(i) == '+') res.add(l + r);
                        else if (exp.charAt(i) == '-') res.add(l - r);
                        else if (exp.charAt(i) == '*') res.add(l * r);
                        else  res.add(l / r);
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.parseInt(exp));
        return res;
    }
}
