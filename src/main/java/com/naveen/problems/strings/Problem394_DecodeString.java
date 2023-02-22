package com.naveen.problems.strings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/decode-string/
// Given an encoded string, return its decoded string.
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
// exactly k times. Note that k is guaranteed to be a positive integer.
//
// You may assume that the input string is always valid; there are no extra white spaces, square brackets are
// well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits
// are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
//
// The test cases are generated so that the length of the output will never exceed 10^5.
// Input: s = "2[abc]3[cd]ef"
// Output: "abcabccdcdcdef"
public class Problem394_DecodeString {
    public static void main(String[] args) {
        Problem394_DecodeString sol = new Problem394_DecodeString();
        String res = sol.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
        System.out.println(res);
    }
    public String decodeString(String s) {
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) q.offer(s.charAt(i));
        return helper(q);
    }

    String helper(Queue<Character> q) {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) num = 10 * num + (c - '0');
            else if (c == '[') {
                String sub = helper(q);
                for (int i = 0; i < num; i++) sb.append(sub);
                num = 0;
            }
            else if (c == ']') break;
            else sb.append(c);
        }
        return sb.toString();
    }
}
