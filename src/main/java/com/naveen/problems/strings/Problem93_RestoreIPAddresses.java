package com.naveen.problems.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/restore-ip-addresses/
// A valid IP address consists of exactly four integers separated by single dots.
// Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
//
// For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and
// "192.168@1.1" are invalid IP addresses.
// Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting
// dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any
// order.
public class Problem93_RestoreIPAddresses {
    public static void main(String[] args) {
        Problem93_RestoreIPAddresses sol = new Problem93_RestoreIPAddresses();
        var res = sol.restoreIpAddresses("25525511135");
        System.out.println(res);
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        generate(s, 0, cur, res, s.length());
        return res;
    }

    private void generate(String s, int index, List<String> cur, List<String> res, int n) {

        if (cur.size() == 4) {
            String ip = cur.stream().collect(Collectors.joining("."));
            if (ip.length() - 3 == s.length())
                res.add(ip);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            String temp = index + i <= n ? s.substring(index, index + i) : "";
            if (isValid(temp)) {
                cur.add(temp);
                generate(s, index + i, cur, res, n);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isValid(String value) {
        if (value.length() == 0) return false;
        if (value.length() == 1) return true;
        if (value.charAt(0) == '0') return false;
        return Integer.parseInt(value) <= 255;
    }
}
