package com.naveen.problems.heaps;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
* https://leetcode.com/problems/task-scheduler/
* Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different
* task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could
* complete either one task or just be idle. However, there is a non-negative integer n that represents the cooldown
* period between two same tasks (the same letter in the array), that is that there must be at least n units of time
* between any two same tasks. Return the least number of units of times that the CPU will take to finish all the given tasks.
*
* Return the least number of units of times that the CPU will take to finish all the given tasks.
* Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation:
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation:
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
* */
public class Problem621_TaskScheduler {
    public static void main(String[] args) {
        Problem621_TaskScheduler sol = new Problem621_TaskScheduler();
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(sol.leastInterval(tasks, 2));
    }
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) count[c - 'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : count)
            if (c != 0) pq.offer(c);
        LinkedList<int[]> q = new LinkedList<>();
        int time = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int freq = pq.poll();
                if (--freq > 0) q.offer(new int[]{freq, time + n});
            }
            if (!q.isEmpty() && q.peek()[1] == time) pq.offer(q.poll()[0]);
        }
        return time;
    }
}
