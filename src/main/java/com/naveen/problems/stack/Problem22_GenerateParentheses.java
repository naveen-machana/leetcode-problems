package com.naveen.problems.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/generate-parentheses/description/
// 22. Generate Parentheses
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
public class Problem22_GenerateParentheses {
    public static void main(String[] args) {
        Problem22_GenerateParentheses s = new Problem22_GenerateParentheses();
        System.out.println(s.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        LinkedList<String> stack = new LinkedList<>();
        String sb = "";
        generate(0, 0, n, res, stack);
        return res;
    }
    void generate(int open, int closed, int n, List<String> res, LinkedList<String> stack) {
        if (stack.size() == 2 * n) {
            String p = stack.stream().collect(Collectors.joining());
            res.add(p);
            return;
        }

        if (open < n) {
            stack.push("(");
            generate(open + 1, closed, n, res, stack);
            stack.pop();
        }

        if (closed < open) {
            stack.push(")");
            generate(open, closed + 1, n, res, stack);
            stack.pop();
        }
    }
}
