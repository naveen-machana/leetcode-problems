package com.naveen.problems.misc;

import java.util.Arrays;

/*
* https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game
* Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters, while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on
* grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw".
* If there are still movements to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
* */
public class Problem1275_FindWinnerTicTacToe {
    public String tictactoe(int[][] moves) {
        int[] a = new int[8], b = new int[8];
        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0], y = moves[i][1], id = i % 2;
            int[] player = id == 0 ? a : b;
            player[x]++;
            player[y + 3]++;
            if (x == y) player[6]++;
            if (x == 2 - y) player[7]++;
        }
        for (int i = 0; i < 8; i++) {
            if (a[i] == 3) return "A";
            if (b[i] == 3) return "B";
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
