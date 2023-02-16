package com.naveen.problems.strings;

import java.util.ArrayList;
import java.util.List;

// https://xiaoguan.gitbooks.io/leetcode/content/LeetCode/293-flip-game-easy.html
// You are playing the following Flip Game with your friend: Given a string that contains only these two
// characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a
// person can no longer make a move and therefore the other person will be the winner.
//
// Write a function to compute all possible states of the string after one valid move.
//
// For example, given s = "++++", after one move, it may become one of the following states:
//
// [
//  "--++",
//  "+--+",
//  "++--"
// ]
//If there is no valid move, return an empty list [].
public class Problem293_FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                StringBuilder temp = new StringBuilder();
                temp.append(s.substring(0, i) + "--");
                if (i + 2 < n) temp.append(s.substring(i + 2));
                res.add(temp.toString());
            }
        }
        return res;
    }
}
