package com.naveen.problems.trie;

// https://leetcode.com/problems/implement-trie-prefix-tree/
// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys
// in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker
//
// Implement the Trie class:
//
// Trie() Initializes the trie object.
// void insert(String word) Inserts the string word into the trie.
// boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
// and false otherwise.
// boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the
// prefix prefix, and false otherwise.
public class Problem208_ImplementTrie {
    private static class Trie {
        private Trie[] childs = new Trie[26];
        private boolean isEndOfWord = false;

        public void insert(String word) {
            char[] c = word.toCharArray();
            Trie cur = this;
            for (int i = 0; i < c.length; i++) {
                if (cur.childs[c[i] - 'a'] == null)
                    cur.childs[c[i] - 'a'] = new Trie();
                cur = cur.childs[c[i] - 'a'];
            }
            cur.isEndOfWord = true;
        }

        public boolean search(String word) {
            char[] c = word.toCharArray();
            Trie cur = this;
            for (int i = 0; i < c.length; i++) {
                if (cur.childs[c[i] - 'a'] == null)
                    return false;
                cur = cur.childs[c[i] - 'a'];
            }
            return cur.isEndOfWord == true;
        }

        public boolean startsWith(String prefix) {
            char[] c = prefix.toCharArray();
            Trie cur = this;
            for (int i = 0; i < c.length; i++) {
                if (cur.childs[c[i] - 'a'] == null)
                    return false;
                cur = cur.childs[c[i] - 'a'];
            }
            return true;
        }
    }
}
