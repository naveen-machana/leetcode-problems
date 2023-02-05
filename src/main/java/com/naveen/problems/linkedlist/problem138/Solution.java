package com.naveen.problems.linkedlist.problem138;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/copy-list-with-random-pointer/
//
public class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        while (temp != null) {
            Node newnode = new Node(temp.val);
            newnode.next = temp.next;
            temp.next = newnode;
            temp = newnode.next;
        }

        temp = head;
        while (temp != null) {
            if (temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }

        Node dummy = new Node(Integer.MIN_VALUE);
        Node start = dummy;
        temp = head;
        while (temp != null) {
            dummy.next = temp.next;
            Node tempNext = temp.next.next;
            temp.next = tempNext;
            dummy = dummy.next;
            temp = tempNext;
        }
        return start.next;
    }
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
