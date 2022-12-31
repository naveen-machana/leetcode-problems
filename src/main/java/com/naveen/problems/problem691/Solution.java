package com.naveen.problems.problem691;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length, n = target.length();
        int[][] mp = new int[m][26];
        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 0);

        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                mp[i][c - 'a']++;
            }
        }

        char[] targetChars = target.toCharArray();
        Arrays.sort(targetChars);
        return count(dp, mp, new String(targetChars));
    }

    private int count(Map<String, Integer> dp, int[][] mp, String target) {
        if (dp.containsKey(target)) return dp.get(target);

        int[] targetChrs = new int[26];
        for (char c : target.toCharArray()) targetChrs[c - 'a']++;

        int ans = Integer.MAX_VALUE, n = mp.length;
        for (int i = 0; i < n; i++) {
            if (mp[i][target.charAt(0) - 'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (targetChrs[j] > 0) {
                    for (int k = 0; k < Math.max(0, targetChrs[j] - mp[i][j]); k++)
                        sb.append((char) (j + 'a'));
                }
            }
            String s = sb.toString();
            int tmp = count(dp, mp, s);
            if (tmp != -1) {
                ans = Math.min(1 + tmp, ans);
            }
        }

        dp.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(target);
    }
}