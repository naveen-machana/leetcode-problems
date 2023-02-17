package com.naveen.problems.strings;

// https://leetcode.com/problems/multiply-strings/description/
// Given two non-negative integers num1 and num2 represented as strings,
// return the product of num1 and num2, also represented as a string.
//
// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
public class Problem43_MultiplyStrings {
    public String multiply2(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0', n2 = num2.charAt(j) - '0';
                int mul = n1 * n2;
                int p1 = i + j, p2 = i + j + 1;
                mul = mul + pos[p2];

                pos[p1] += mul / 10;
                pos[p2] = mul % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) if (!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        char[] num1chars = num1.toCharArray();
        String prev = "";

        for (int i = 0; i < num1chars.length; i++) {
            String temp = prepend("", i);
            temp = multiply(num2, num1chars[i] - '0', temp);
            temp = add(temp, prev);
            prev = temp;
        }

        String intRes = new StringBuilder(prev).reverse().toString();
        int i = 0, n = intRes.length();
        while (i < n && intRes.charAt(i) == '0') i++;
        return i < n ? intRes.substring(i) : "0";
    }

    private String multiply(String num, int with, String res) {
        int c = 0, i = 0, n = num.length();
        StringBuilder sb = new StringBuilder(res);
        while (i < n) {
            int sum = c;
            sum = sum + with * (num.charAt(i++) - '0');
            sb.append(sum % 10);
            c = sum / 10;
        }
        if (c > 0) sb.append(c);
        return sb.toString();
    }

    private String prepend(String one, int n) {
        StringBuilder sb = new StringBuilder(one);
        for (int i = 0; i < n; i++)
            sb.insert(0, '0');
        return sb.toString();
    }

    public String add(String one, String two) {
        int i = 0, j = 0, m = one.length(), n = two.length(), c = 0;
        StringBuilder res = new StringBuilder();
        while (i < m || j < n) {
            int sum = c;
            if (i < m) sum += one.charAt(i++) - '0';
            if (j < n) sum += two.charAt(j++) - '0';
            res.append(sum % 10);
            c = sum / 10;
        }
        if (c != 0) res.append(c);
        return res.toString();
    }
}
