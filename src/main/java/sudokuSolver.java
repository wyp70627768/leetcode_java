import java.util.HashSet;

/*
37. Sudoku Solver
Hard

1246

77

Favorite

Share
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
 */
public class sudokuSolver {
    public static void solveSudoku(char[][] board) {
        solve(board);
    }
    private static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0;  j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (int k = 0; k <= 9; k++) {
                    board[i][j] = (char) (k + '0');
                    if (isValid(board, i, j) && solve(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int a, int b) {
        HashSet<Character> row = new HashSet<Character>();
        HashSet<Character> column = new HashSet<Character>();
        HashSet<Character> grid = new HashSet<Character>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (row.contains(board[a][j]))
                    return false;
                if (column.contains(board[i][b]))
                    return false;
                row.add(board[a][j]);
                column.add(board[i][b]);
                int x = a/3*3 + i/3;
                int y = b/3*3 + j/3;
                if (grid.contains(board[x][y]))
                    return false;
                grid.add(board[x][y]);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = new {{"5", "3", ".", ".", "7", ".", ".", ".", "."}, {"6", ".", ".", "1", "9", "5", ".", ".", "."}, {".", "9", "8", ".", ".", ".", ".", "6", "."},
                        {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                            {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                                    {".", "6", ".", ".", ".", ".", "2", "8", "."},
                                        {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                                            {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
    }
}
