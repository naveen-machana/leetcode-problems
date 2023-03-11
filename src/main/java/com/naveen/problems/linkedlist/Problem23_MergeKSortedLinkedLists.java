package com.naveen.problems.linkedlist;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/merge-k-sorted-lists/
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
* */
public class Problem23_MergeKSortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode start = new ListNode();
        ListNode tail = start;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null)
                pq.offer(lists[i]);
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            tail.next = temp;
            tail = tail.next;
            if (temp.next != null) pq.offer(temp.next);
        }
        return  start.next;
    }
}
