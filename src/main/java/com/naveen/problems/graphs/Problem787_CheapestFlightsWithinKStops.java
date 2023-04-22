package com.naveen.problems.graphs;

import java.util.*;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
// There are n cities connected by some number of flights. You are given an array flights
// where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
//
//You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
// If there is no such route, return -1.
public class Problem787_CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int[][] f = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(findCheapestPrice(3, f, 0, 2, 1));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<List<Integer>>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] f : flights) g.get(f[0]).add(List.of(f[1], f[2]));

        Queue<List<Integer>> q = new LinkedList<>();
        q.add(List.of(0, src, 0)); // stops, vertex, distance;
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        while (!q.isEmpty()) {
            List<Integer> cur = q.poll();
            int v = cur.get(1), stops = cur.get(0), distance = cur.get(2);
            if (stops > k) continue;
            for (List<Integer> adj : g.get(v)) {
                int adjV = adj.get(0), adjD = adj.get(1);
                if (distance + adjD < distances[adjV] && stops <= k) {
                    distances[adjV] = distance + adjD;
                    q.offer(List.of(stops + 1, adjV, distances[adjV]));
                }
            }
        }

        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }
}