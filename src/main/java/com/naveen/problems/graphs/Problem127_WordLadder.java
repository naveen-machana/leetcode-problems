package com.naveen.problems.graphs;

import java.util.*;

public class Problem127_WordLadder {
    public static void main(String[] args) {
        Problem127_WordLadder sol = new Problem127_WordLadder();
        String[] words = {"hot","dot","dog","lot","log","cog"};
        System.out.println(sol.ladderLength("hit", "cog", Arrays.asList(words)));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        if (!dictionary.contains(endWord)) return 0;
        dictionary.add(beginWord);

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int steps = 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) return steps;

                for (int j = 0; j < cur.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        char[] chars = cur.toCharArray();
                        chars[j] = k;
                        String stepString = new String(chars);
                        if (!visited.contains(stepString) && dictionary.contains(stepString)) {
                            q.add(stepString);
                            visited.add(stepString);
                        }
                    }
                }
            }
            steps++;
        }

        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        if (!dictionary.contains(endWord)) return 0;
        dictionary.add(beginWord);
        LinkedList<String> q = new LinkedList<>();
        q.add(endWord);
        Set<String> visited = new HashSet<>();
        visited.add(endWord);
        Map<String, List<String>> g = new HashMap<>();
        while (!q.isEmpty()) {
            String cur = q.poll();
            for (String adj : dictionary) {
                if (!visited.contains(adj) && diff(cur, adj) == 1) {
                    g.computeIfAbsent(cur, k -> new ArrayList<>()).add(adj);
                    g.computeIfAbsent(adj, k -> new ArrayList<>()).add(cur);
                    q.add(adj);
                    visited.add(adj);
                }
            }
        }

        int res = shortestPath(beginWord, endWord, g);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private int shortestPath(String source, String target, Map<String, List<String>> g) {
        Queue<Object[]> q = new PriorityQueue<>((one, two) -> Integer.compare((Integer)one[1], (Integer)two[1]));
        q.add(new Object[]{ source, 1 } );
        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            Object[] cur = q.poll();
            String curString = (String)cur[0];
            int dist = (Integer)cur[1];
            if (curString.equals(target)) return dist;
            if (visited.contains(curString)) continue;
            visited.add(curString);
            for (String adj : (List<String>)g.getOrDefault(curString, Collections.EMPTY_LIST)) {
                if (!visited.contains(adj)) {
                    q.add(new Object[]{adj, dist + 1});
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private int diff(String cur, String adj) {
        char[] c = cur.toCharArray();
        char[] a = adj.toCharArray();
        int diff = 0;
        for (int i = 0, j = 0; i < c.length && j < a.length; i++, j++) {
            if (c[i] != a[i]) diff++;
        }
        return diff;
    }
}
