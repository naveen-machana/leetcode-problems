package com.naveen.problems.arrays;

public class Problem706_HashMap {
    class MyHashMap {

        private static class ListNode {
            private int key;
            private int value;
            private ListNode next;
            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private ListNode[] map;
        public MyHashMap() {
            map = new ListNode[10000];
            for (int i = 0; i < 10000; i++) map[i] = new ListNode(-1, -1);
        }

        public void put(int key, int value) {
            ListNode ptr = map[ key % map.length];
            while (ptr.next != null) {
                if (ptr.next.key == key) {
                    ptr.next.value = value;
                    return;
                }
                ptr = ptr.next;
            }
            ptr.next = new ListNode(key, value);
        }

        public int get(int key) {
            ListNode ptr = map[ key % map.length];
            while (ptr.next != null) {
                if (ptr.next.key == key) {
                    return ptr.next.value;
                }
                ptr = ptr.next;
            }
            return -1;
        }

        public void remove(int key) {
            ListNode ptr = map[ key % map.length];
            while (ptr.next != null) {
                if (ptr.next.key == key) {
                    ptr.next = ptr.next.next;
                    return;
                }
                ptr = ptr.next;
            }
        }
    }
}
