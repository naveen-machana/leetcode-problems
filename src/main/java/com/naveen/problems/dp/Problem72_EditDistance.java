package com.naveen.problems.dp;

/*
* https://leetcode.com/problems/edit-distance/
* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
* You have the following three operations permitted on a word:
* Insert a character
* Delete a character
* Replace a character
*
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
* */
public class Problem72_EditDistance {
    public int minDistance2(String word1, String word2) {
         return  minOps(word1, word2, word1.length(), word2.length());
    }

    private int minOps(String a, String b, int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;
        if (a.charAt(m - 1) == b.charAt(n - 1)) return minOps(a, b, m - 1, n - 1);
        else return 1 + Math.min(minOps(a, b, m, n - 1),
                Math.min(minOps(a, b, m - 1, n),
                        minOps(a, b, m - 1, n - 1)));
    }

    public int minDistance3(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = i;
        for (int i = 1; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    public int minDistance(String a, String b) {
        int m = a.length(), n = b.length(), pre = 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) dp[i] = i;

        for (int i = 1; i <= m; i++) {
            pre = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (a.charAt(i - 1) == b.charAt(j - 1)) dp[j] = pre;
                else dp[j] = 1 + Math.min(pre, Math.min(dp[j - 1], dp[j]));
                pre = temp;
            }
        }
        return dp[n];
    }
}
