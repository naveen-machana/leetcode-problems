package com.naveen.problems.problem269;

import java.util.*;

// https://tenderleo.gitbooks.io/leetcode-solutions-/content/GoogleHard/269.html
// There is a new alien language which uses the latin alphabet.
// However, the order among letters are unknown to you.
// You receive a list of words from the dictionary, where words are sorted lexicographically
// by the rules of this new language. Derive the order of letters in this language.
public class Solution {
    public static void main(String[] args) {
        String[] dict = {"baa","abcd","abca","cab","cad"};
        String res = findOrder(dict, 5, 4);
        System.out.println(res);
    }
    public static String findOrder(String[] dict, int n, int k) {
        Map<Character, Set<Character>> g = new HashMap<>();
        int[] indegree = new int[26];
        Set<Character> allChars = new HashSet<>();
        for (String word : dict) {
            for (char c : word.toCharArray())
                allChars.add(c);
        }

        for (int i = 0; i < n - 1; i++) {
            char[] first = dict[i].toCharArray();
            char[] second = dict[i + 1].toCharArray();

            for (int j = 0; j < Math.min(first.length, second.length); j++) {
                if (first[j] != second[j]) {
                    g.computeIfAbsent(first[j], key -> new HashSet<>());
                    if (!g.get(first[j]).contains(second[j])) {
                        g.get(first[j]).add(second[j]);
                        indegree[second[j] - 'a']++;
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (char key : allChars)
            if (indegree[key - 'a'] == 0)
                q.offer(key);

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Character cur = q.poll();
            sb.append(cur);
            Set<Character> neighbours = g.getOrDefault(cur, Collections.EMPTY_SET);
            for (Character adj : neighbours) {
                if (--indegree[adj - 'a'] == 0)
                    q.offer(adj);
            }
        }

        Set<Character> found = new HashSet<>();
        for (char c : sb.toString().toCharArray())  found.add(c);
        allChars.removeAll(found);

        for (char c : allChars)
            sb.append(c);

        return sb.toString();
    }
}
