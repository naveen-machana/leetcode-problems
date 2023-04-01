package com.naveen.problems.stack;

import java.util.Arrays;
import java.util.LinkedList;

/*
* https://leetcode.com/problems/car-fleet/
* There are n cars going to the same destination along a one-lane road. The destination is target miles away.
* You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car
* and speed[i] is the speed of the ith car (in miles per hour). A car can never pass another car ahead of it,
* but it can catch up to it and drive bumper to bumper at the same speed. The faster car will slow down to match the
* slower car's speed. The distance between these two cars is ignored (i.e., they are assumed to have the same position).
* A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also
* a car fleet. If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
Return the number of car fleets that will arrive at the destination.
*
* Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12.
The car starting at 0 does not catch up to any other car, so it is a fleet by itself.
The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6.
* he fleet moves at speed 1 until it reaches target.
Note that no other cars meet these fleets before the destination, so the answer is 3.
*
* Input: target = 100, position = [0,2,4], speed = [4,2,1]
Output: 1
Explanation:
The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The fleet moves at speed 2.
Then, the fleet (speed 2) and the car starting at 4 (speed 1) become one fleet, meeting each other at 6. The fleet moves
*  at speed 1 until it reaches target.
* */
public class Problem853_CarFleet {
    public static void main(String[] args) {
        Problem853_CarFleet sol = new Problem853_CarFleet();
        int[] position = {6,8}, speed = {3,2};
        System.out.println(sol.carFleet(10, position, speed));
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) cars[i] = new int[]{position[i], speed[i]};
        Arrays.sort(cars, (one, two) -> two[0] - one[0]);
        LinkedList<Double> stack = new LinkedList<>();
        for (int[] car : cars) {
            stack.push((double)(target - car[0])/car[1]);
            if (stack.size() >= 2 && stack.get(0) <= stack.get(1)) stack.pop();
        }
        return stack.size();
    }
}
