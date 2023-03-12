package com.naveen.problems.graphs;

import java.util.*;

// https://leetcode.com/problems/reconstruct-itinerary/
// 332. Reconstruct Itinerary
// You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival
// airports of one flight. Reconstruct the itinerary in order and return it.
//
// All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK".
// If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when
// read as a single string.
//
// For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
// You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
// Solution: Eulerian Path and Eulerian Circuit - If both exists in a graph then its a euler graph
// Eulerian Path: If Euler Path exists, then you should be able to visit all edges exactly once
// Eulerian Circuit: If Euler Circuit exists, then you should be able to visit all edges exactly once and returned back
// source vertex.
class Problem332_ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> g = new HashMap<>();
        for (List<String> tkt : tickets)
            g.computeIfAbsent(tkt.get(0), k -> new PriorityQueue<>()).offer(tkt.get(1));

        LinkedList<String> res = new LinkedList<>();
        visit("JFK", g, res);
        return res;
    }

    private void visit(String src, Map<String, PriorityQueue<String>> g, LinkedList<String> res) {
        while (g.containsKey(src) && !g.get(src).isEmpty())
            visit(g.get(src).poll(), g, res);

        res.addFirst(src);
    }
}