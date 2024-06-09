package com.naveen.problems.arrays;

public class Problem705_HashSet {

    private static class MyHashSet {

        private static class ListNode {
            private int key;
            private ListNode next;
            public ListNode(int key) {
                this.key = key;
            }
        }
        private ListNode[] set;

        public MyHashSet() {
            set = new ListNode[10000];
            for (int i = 0; i < set.length; i++) set[i] = new ListNode(0);
        }

        public void add(int key) {
            ListNode cur = set[key % set.length];
            while (cur.next != null) {
                if (cur.next.key == key) return;
                cur = cur.next;
            }
            cur.next = new ListNode(key);
        }

        public void remove(int key) {
            ListNode cur = set[key % set.length];
            while (cur.next != null) {
                if (cur.next.key == key) {
                    cur.next = cur.next.next;
                    return;
                }
                cur = cur.next;
            }
        }

        public boolean contains(int key) {
            ListNode cur = set[key % set.length];
            while (cur.next != null) {
                if (cur.next.key == key) return true;
                cur = cur.next;
            }
            return false;
        }
    }
}
