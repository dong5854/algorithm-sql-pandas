// https://leetcode.com/problems/valid-sudoku/description/
import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> block = new HashSet<>();
            int blockRow = 3*(i/3);
            int blockCol = 3*(i%3);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) return false;
                if (board[j][i] != '.' && !col.add(board[j][i])) return false;
                if (board[blockRow + j/3][blockCol + j%3] != '.' && !block.add(board[blockRow + j/3][blockCol + j%3])) return false;
            }
        }
        return true;
    }
}