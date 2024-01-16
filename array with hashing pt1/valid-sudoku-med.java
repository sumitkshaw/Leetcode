import java.util.Set;
import java.util.HashSet;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = null;
        Set<Character> colSet = null;

        for (int i = 0; i < 9; i++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char r = board[i][j];
                char c = board[j][i];
                if (r != '.') {
                    if (rowSet.contains(r)) {
                        return false;
                    } else {
                        rowSet.add(r);
                    }
                }
                if (c != '.') {
                    if (colSet.contains(c)) {
                        return false;
                    } else {
                        colSet.add(c);
                    }
                }
            }
        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!checkBlock(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkBlock(int idxI, int idxJ, char[][] board) {
        Set<Character> blockSet = new HashSet<>();
        int rows = idxI + 3;
        int cols = idxJ + 3;
        for (int i = idxI; i < rows; i++) {
            for (int j = idxJ; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (blockSet.contains(board[i][j])) {
                    return false;
                }

                blockSet.add(board[i][j]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Example Sudoku board (0 denotes empty spaces)
        char[][] sudokuBoard = {
            {'5', '3', '0', '0', '7', '0', '0', '0', '0'},
            {'6', '0', '0', '1', '9', '5', '0', '0', '0'},
            {'0', '9', '8', '0', '0', '0', '0', '6', '0'},
            {'8', '0', '0', '0', '6', '0', '0', '0', '3'},
            {'4', '0', '0', '8', '0', '3', '0', '0', '1'},
            {'7', '0', '0', '0', '2', '0', '0', '0', '6'},
            {'0', '6', '0', '0', '0', '0', '2', '8', '0'},
            {'0', '0', '0', '4', '1', '9', '0', '0', '5'},
            {'0', '0', '0', '0', '8', '0', '0', '7', '9'}
        };

        Solution solution = new Solution();
        boolean isValid = solution.isValidSudoku(sudokuBoard);

        if (isValid) {
            System.out.println("The Sudoku board is valid.");
        } else {
            System.out.println("The Sudoku board is not valid.");
        }
    }
}
