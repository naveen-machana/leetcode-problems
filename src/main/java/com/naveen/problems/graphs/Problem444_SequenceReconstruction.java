package com.naveen.problems.graphs;

import java.util.*;

public class Problem444_SequenceReconstruction {
    boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> g = new HashMap<>();

        Map<Integer, Integer> degree = new HashMap<>();
        Set<Integer> inGraph = new HashSet<>();
        for (List<Integer> e : seqs) {
            degree.merge(e.get(0), 1, (ov, v) -> ov + v);
            g.computeIfAbsent(e.get(0), k -> new HashSet<>()).add(e.get(1));
            inGraph.add(e.get(0));
            inGraph.add(e.get(1));
        }

        for (int o : org) {
            if (!inGraph.contains(o))
                return false;
        }

        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : degree.entrySet())
            if (entry.getValue() == 0)
                q.add(entry.getKey());

        if (q.size() > 1) return false;
        int[] res = new int[org.length];
        int index = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            res[index++] = cur;

            for (int adj : g.get(cur)) {
                int adjdegree = degree.get(adj) - 1;
                degree.put(adj, adjdegree);
                if (adjdegree == 0)
                    q.offer(adj);
            }

            if (q.size() > 1) return false;
        }

        for (int i = 0; i < res.length; i++){
            if (res[i] != org[i])
                return false;
        }

        return true;
    }
}
