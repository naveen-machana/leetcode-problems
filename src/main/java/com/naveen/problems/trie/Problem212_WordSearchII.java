package com.naveen.problems.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* https://leetcode.com/problems/word-search-ii/
* Given an m x n board of characters and a list of strings words, return all words on the board.
* Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
* vertically neighboring. The same letter cell may not be used more than once in a word.
* Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
* words = ["oath","pea","eat","rain"]
* Output: ["eat","oath"]
* */
public class Problem212_WordSearchII {
    private static class Trie {
        private Trie[] children = new Trie[26];
        private boolean isEndOfWord;
        public void add(String word) {
            Trie cur = this;
            for (char c : word.toCharArray()) {
                Trie next = cur.children[c - 'a'];
                if (next == null) next = new Trie();
                cur.children[c - 'a'] = next;
                cur = next;
            }
            cur.isEndOfWord = true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words) trie.add(word);
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find(i, j, m, n, trie, visited, board, res, "");
            }
        }
        return new ArrayList<>(res);
    }

    int[][] rc = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    private void find(int i, int j, int m, int n, Trie trie, Set<String> visited, char[][] board, Set<String> res, String sb) {
        String key = i + "#" + j;
        if (i < 0 || j < 0 || i >= m || j >= n || visited.contains(key)) return;
        char c = board[i][j];
        Trie next = trie.children[c - 'a'];
        if (next == null) return;
        visited.add(key);
        sb = sb + c;
        if (next.isEndOfWord) res.add(sb);
        for (int[] xy : rc) find(i + xy[0], j + xy[1], m, n, next, visited, board, res, sb);
        visited.remove(key);
    }
}
