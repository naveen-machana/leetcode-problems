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
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) Arrays.fill(board[i], ' ');
        boolean playerA = false; char playerChar = 'O';
        for (int[] move : moves) {
            playerA = !playerA;
            playerChar = playerA ? 'X' : 'O';
            board[move[0]][move[1]] = playerChar;
        }
        String res = "Pending";
        if (rowMatches(board, playerChar) || colMatches(board, playerChar) || diagonalMatches(board, playerChar))
            return playerA ? "A" : "B";
        else if (boardFull(board)) return "Draw";
        else return res;
    }

    private boolean rowMatches(char[][] board, char playerChar) {
        for (int i = 0; i < 3; i++)  {
            boolean res = true;
            for (int j = 0; j < 3; j++)
                res &= board[i][j] == playerChar;
            if (res) return true;
        }
        return false;
    }

    private boolean colMatches(char[][] board, char playerChar) {
        for (int i = 0; i < 3; i++) {
            boolean res = true;
            for (int j = 0; j < 3; j++)
                res &= board[j][i] == playerChar;
            if (res) return true;
        }
        return false;
    }

    private boolean diagonalMatches(char[][] board, char playerChar) {
        if (board[0][0] == playerChar && board[1][1] == playerChar && board[2][2] == playerChar) return  true;
        if (board[0][2] == playerChar && board[1][1] == playerChar && board[2][0] == playerChar) return  true;
        return false;
    }

    private boolean boardFull(char[][] board) {
        boolean res = true;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                res &= board[i][j] != ' ';
        return res;
    }
}
