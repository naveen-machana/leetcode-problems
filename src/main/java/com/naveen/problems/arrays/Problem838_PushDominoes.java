package com.naveen.problems.arrays;

import java.util.ArrayDeque;

public class Problem838_PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] dom = dominoes.toCharArray();
        ArrayDeque<Entry> q = new ArrayDeque<>();
        for (int i = 0; i < dom.length; i++)
            if (dom[i] != '.')
                q.push(new Entry(i, dom[i]));

        while (!q.isEmpty()) {
            Entry e = q.pollFirst();
            if (e.c == 'L' && e.index > 0 && dom[e.index] == '.') {
                q.push(new Entry(e.index - 1, 'L'));
                dom[e.index - 1] = 'L';
            }
            else if(e.c == 'R') {
                if ( (e.index + 1) < dom.length && dom[e.index + 1] == '.') {
                    if ( (e.index + 2) < dom.length && dom[e.index + 2] == 'L') {
                        q.pollFirst();
                    }
                    else {
                        q.push(new Entry(e.index + 1, 'R'));
                        dom[e.index + 1] = 'R';
                    }
                }
            }
        }

        return new String(dom);
    }

    private static class Entry {
        int index;
        char c;
        public Entry(int index, char c) {
            this.index = index;
            this.c = c;
        }
    }
}
