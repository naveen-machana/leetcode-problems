package com.naveen.problems.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/lru-cache/
* Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
* Implement the LRUCache class:
* LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
* int get(int key) Return the value of the key if the key exists, otherwise return -1.
* void put(int key, int value) Update the value of the key if the key exists.
* Otherwise, add the key-value pair to the cache.
* If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
* Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
* */
public class Problem146_LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
    static class LRUCache {
        Map<Integer, Node> map;
        Node head, tail;
        int capacity;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.capacity = capacity;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            join(head, tail);
        }

        private void join(Node one, Node two) {
            one.right = two;
            two.left = one;
        }

        private void remove(Node cur) {
            join(cur.left, cur.right);
            cur.left = cur.right = null;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                remove(map.get(key));
                insert(map.get(key));
                return map.get(key).val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                remove(map.get(key));
                map.remove(key);
            }
            map.put(key, new Node(key, value));
            insert(map.get(key));
            if (map.size() > capacity) {
                Node remove = tail.left;
                remove(remove);
                map.remove(remove.key);
            }
        }

        private void insert(Node cur) {
            Node headNext = head.right;
            join(head, cur);
            join(cur, headNext);
        }

        private static class Node {
            int key, val;
            Node left, right;
            public Node(int key, int val) { this.key = key; this.val = val; }
        }
    }
}
