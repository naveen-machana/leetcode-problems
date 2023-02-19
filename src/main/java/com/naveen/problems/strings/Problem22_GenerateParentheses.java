package com.naveen.problems.strings;

import java.util.ArrayList;
import java.util.List;

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
        generate(res, 0, 0, n, "");
        return res;
    }

    private void generate(List<String> res, int open, int closed, int n, String cur) {
        if (cur.length() == 2 * n) {
            res.add(cur);
            return;
        }

        if (open < n) {
            generate(res, open + 1, closed, n, cur + '(');
        }
        if (closed < open) {
            generate(res, open, closed + 1, n, cur + ')');
        }
    }
}
