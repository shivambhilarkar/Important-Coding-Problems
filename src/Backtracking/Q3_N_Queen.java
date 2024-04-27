package Backtracking;

public class Q3_N_Queen {

    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        int row = 0;
        int[] count = {0};
        getCount(board, 0, count);
        return count[0];
    }

    //Backtracking
    public void getCount(int[][] board, int row, int[] count) {
        if (row == board.length) {
            count[0] += 1;
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafePosition(board, row, col)) {
                board[row][col] = 1;
                getCount(board, row + 1, count);
                board[row][col] = 0;
            }
        }
    }


    //helper function to check current position status
    private boolean isSafePosition(int[][] board, int row, int col) {
        //current column
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        //left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; j--, i--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        //right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }


}
