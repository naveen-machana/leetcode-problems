package com.naveen.problems.heaps;

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
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o, t) -> o.val - t.val);
        for (ListNode f : lists)
            if (f != null)
                pq.offer(f);
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            ListNode next = temp.next;
            tail.next = temp;
            tail = temp;
            if (next != null) pq.offer(next);
        }
        return dummy.next;
    }
}
