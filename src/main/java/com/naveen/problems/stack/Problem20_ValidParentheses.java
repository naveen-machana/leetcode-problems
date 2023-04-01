package com.naveen.problems.stack;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/valid-parentheses/
// 20. Valid Parentheses
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// An input string is valid if:
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
public class Problem20_ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of('(', ')', '[', ']', '{', '}');
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) stack.push(map.get(c));
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
