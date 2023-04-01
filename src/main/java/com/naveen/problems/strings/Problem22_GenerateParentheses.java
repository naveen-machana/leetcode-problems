package com.naveen.problems.strings;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/description/
// 22. Generate Parentheses
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
public class Problem22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String sb = "";
        generate(0, 0, n, res, sb);
        return res;
    }

    void generate(int open, int closed, int n, List<String> res, String sb) {
        if (sb.length() == 2 * n) { res.add(sb); return;}
        if (open < n) generate(open + 1, closed, n, res, sb + "(");
        if (closed < open) generate(open, closed + 1, n, res, sb + ")");
    }
}
