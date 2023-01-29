package com.naveen.problems.problem990;

import java.util.*;

// https://leetcode.com/problems/satisfiability-of-equality-equations/
// 990. Satisfiability of Equality Equations
// You are given an array of strings equations that represent relationships between variables where each string
// equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are
// lowercase letters (not necessarily different) that represent one-letter variable names.
//
//Return true if it is possible to assign integers to variable names so as to satisfy all the given equations,
// or false otherwise.
public class Solution {
    public static void main(String[] args) {
        String[] eq = {"c==c","b==d","x!=z"};
        System.out.println(equationsPossible(eq));
    }
    public static boolean equationsPossible(String[] equations) {
        Set<char[]> notEquals = new HashSet<>();
        Map<Character, Set<Character>> g = new HashMap<>();
        for (String eq : equations) {
            char first = eq.charAt(0);
            char second = eq.charAt(3);
            String symbol = eq.substring(1, 3);
            if (symbol.equals("!="))
                notEquals.add(new char[]{first, second});
            else {
                g.computeIfAbsent(first, k -> new HashSet<>()).add(second);
                g.computeIfAbsent(second, k -> new HashSet<>()).add(first);
            }
        }

        for (char[] e : notEquals)
            if (canMeet(g, e[0], e[1], new HashSet<>()))
                return false;

        return true;
    }

    private static boolean canMeet(Map<Character, Set<Character>> g, char s, char d, Set<Character> visited) {
        if (s == d) return true;
        visited.add(s);

        Set<Character> neighbours = g.getOrDefault(s, Collections.EMPTY_SET);
        for (char adj : neighbours) {
            if (!visited.contains(adj) && canMeet(g, adj, d, visited))
                return true;
        }

        return false;
    }
}

