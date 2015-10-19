package com.mw.leetcode.p31top40;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku36
{
    public static boolean isValidSudoku(char[][] board)
    {
        Set<Character> result = new HashSet<>();

        // Rows are valid.
        for (int i = 0; i < 9; i++)
        {
            result.clear();
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] == '.')
                    continue;

                if (result.contains(board[i][j]))
                    return false;

                result.add(board[i][j]);
            }
        }

        // Columns are valid.
        for (int j = 0; j < 9; j++)
        {
            result.clear();
            for (int i = 0; i < 9; i++)
            {
                if (board[i][j] == '.')
                    continue;

                if (result.contains(board[i][j]))
                    return false;

                result.add(board[i][j]);
            }
        }

        // Each 3x3 block is valid.
        int startRow = 0;
        int startColumn = 0;
        while (startRow < 9)
        {
            result.clear();
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (board[startRow + i][startColumn + j] == '.')
                        continue;

                    if (result.contains(board[startRow + i][startColumn + j]))
                        return false;

                    result.add(board[startRow + i][startColumn + j]);
                }
            }

            if (startColumn < 6)
                startColumn = startColumn + 3;
            else
            {
                startColumn = 0;
                startRow = startRow + 3;
            }
        }

        return true;
    }

    public static boolean isValidSudoku1(char[][] board) {
    	if (board == null || board.length != 9 || board[0].length != 9)
    		return false;
    	// check each column
    	for (int i = 0; i < 9; i++) {
    		boolean[] m = new boolean[9];
    		for (int j = 0; j < 9; j++) {
    			if (board[i][j] != '.') {
    				if (m[(int) (board[i][j] - '1')]) {
    					return false;
    				}
    				m[(int) (board[i][j] - '1')] = true;
    			}
    		}
    	}

    	//check each row
    	for (int j = 0; j < 9; j++) {
    		boolean[] m = new boolean[9];
    		for (int i = 0; i < 9; i++) {
    			if (board[i][j] != '.') {
    				if (m[(int) (board[i][j] - '1')]) {
    					return false;
    				}
    				m[(int) (board[i][j] - '1')] = true;
    			}
    		}
    	}

    	//check each 3*3 matrix
    	for (int block = 0; block < 9; block++) {
    		boolean[] m = new boolean[9];
    		for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
    			for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
    				if (board[i][j] != '.') {
    					if (m[(int) (board[i][j] - '1')]) {
    						return false;
    					}
    					m[(int) (board[i][j] - '1')] = true;
    				}
    			}
    		}
    	}

    	return true;
    }

    public static void main(String[] args)
    {
        String[] a = {
                "....8....",
                "......5..",
                "....4..2.",
                "...3.9...",
                "..18..9..",
                ".....51..",
                "..3..8...",
                ".12.3....",
                ".....7..1"};
        char[][] boards = new char[9][9];
        for ( int i = 0; i < 9; i++)
        {
            boards[i] = a[i].toCharArray();
        }
        System.out.println(isValidSudoku(boards));
    }
}
