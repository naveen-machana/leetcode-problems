package com.naveen.problems.stack;

import java.util.ArrayDeque;

/*
* https://leetcode.com/problems/min-stack/
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
* */
public class Problem155_MinStack {
    static class MinStack {
        ArrayDeque<Integer> st1 = new ArrayDeque<>();
        ArrayDeque<Integer> min = new ArrayDeque<>();
        public MinStack() {

        }

        public void push(int val) {
            if (st1.isEmpty()) {
                st1.push(val);
                min.push(val);
            }
            else {
                st1.push(val);
                if (min.peek() >= val)
                    min.push(val);
            }
        }

        public void pop() {
            if (st1.peek().equals(min.peek())) min.pop();
            st1.pop();
        }

        public int top() {
            return st1.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
