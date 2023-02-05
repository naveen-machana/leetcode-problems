package com.naveen.problems.linkedlist;

import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
// Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
// (i) a next pointer to the next node,
// (ii) a bottom pointer to a linked list where this node is head.
// Each of the sub-linked-list is in sorted order.
// Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
public class LinkedListFlattening {

    private static class Node {
        int data;
        Node next;
        Node bottom;
        Node(int d) {
            data = d;
        }
    }

    Node flatten2(Node root) {
        PriorityQueue<Node> pq = new PriorityQueue<>((one, two) -> one.data - two.data);
        Node temp = new Node(Integer.MIN_VALUE);
        Node start = temp;

        Node cur = root;
        while (cur != null) {
            pq.offer(cur);
            cur = cur.next;
        }

        while (!pq.isEmpty()) {
            cur = pq.poll();
            Node next = cur.bottom;
            temp.bottom = cur;
            if (next != null)
                pq.offer(next);
            temp = temp.bottom;
        }

        return start.bottom;
    }
}
