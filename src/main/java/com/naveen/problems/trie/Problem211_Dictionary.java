package com.naveen.problems.trie;

// Design a data structure that supports adding new words and finding if a string matches any
// previously added string.
//
//Implement the WordDictionary class:
//
// WordDictionary() Initializes the object.
// void addWord(word) Adds word to the data structure, it can be matched later.
// bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
// word may contain dots '.' where dots can be matched with any letter.
public class Problem211_Dictionary {
    private static class WordDictionary {
        Trie trie;
        public WordDictionary() {
            trie = new Trie();
        }

        public void addWord(String word) {
            trie.insert(word);
        }

        public boolean search(String word) {
            return trie.search(word);
        }

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
                return searchRec(0, word, this);
            }

            private boolean searchRec(int index, String word, Trie trie) {
                if (trie == null) return false;
                if (index >= word.length()) return trie.isEndOfWord;
                Trie cur = trie;
                for (int i = index; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (c != '.') {
                        if (cur.childs[c - 'a'] == null) return false;
                        cur = cur.childs[c - 'a'];
                    }
                    else {
                        for (Trie temp : cur.childs) {
                            if (temp != null && searchRec(i + 1, word, temp))
                                return true;
                        }
                        return false;
                    }
                }
                return cur.isEndOfWord;
            }
        }
    }
}
