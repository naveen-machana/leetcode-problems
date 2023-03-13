package com.naveen.problems.graphs;

// https://leetcode.com/problems/accounts-merge/
// 721. Accounts Merge
// Given a list of accounts where each element accounts[i] is a list of strings,
// where the first element accounts[i][0] is a name, and the rest of the elements are
// emails representing emails of the account.
//
//Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some
// common email to both accounts. Note that even if two accounts have the same name, they may belong to different
// people as people could have the same name. A person can have any number of accounts initially, but all of their
// accounts definitely have the same name.
//
//After merging the accounts, return the accounts in the following format: the first element of each
// account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be
// returned in any order.

import java.nio.charset.StandardCharsets;
import java.util.*;

// Any problem that involves merging connected components (accounts) is a
// natural fit for the Disjoint Set Union (DSU) data structure.
public class Problem721_AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> owners = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (owners.containsKey(email)) {
                    int cur = i;
                    int prev = owners.get(email);
                    if (cur != prev)
                        uf.connect(cur, prev);
                }
                else {
                    owners.put(email, i);
                }
            }
        }

        Map<Integer, Set<String>> users = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int parent = uf.find(i);
            List<String> emails = accounts.get(i);
            users.computeIfAbsent(parent, k -> new TreeSet<>()).addAll(emails.subList(1, emails.size()));
        }

        List<List<String>> res = new ArrayList<>();
        for (int usr : users.keySet()) {
            String name = accounts.get(usr).get(0);
            List<String> newList = new ArrayList<>(users.get(usr));
            newList.add(0, name);
            res.add(newList);
        }

        return res;
    }

    private static class UnionFind {
        int[] p;
        public UnionFind(int n) {
            p = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }
        public int find(int x) {
            if (x == p[x]) return x;
            p[x] = find(p[x]);
            return p[x];
        }
        public void connect(int x, int y) {
            int xr = find(x);
            int xy = find(y);
            if (xr == xy) return;
            p[xr] = xy;
        }
        public boolean areConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

}
