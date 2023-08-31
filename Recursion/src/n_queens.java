import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class n_queens {
    static List<List<String>> res = new LinkedList<>();

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] cs : board) {
            Arrays.fill(cs, '_');
        }
        helper(board, 0, 0, n);
        return res;
    }

    private static void helper(char[][] board, int row, int col, int n) {
        // Column out of bound
        if (col == board[0].length) {
            col = 0;
            row++;
        }
        // n is 0 then add to the res
        if (n == 0) {
            res.add(toString(board));
            return;
        }
        // Row out of bound
        if (row == board.length)
            return;

        // Place queen here if valid
        if (isValid(board, row, col)) {
            board[row][col] = 'Q';
            n--;
            helper(board, row, col + 1, n);
            // backtrack unchoose the option
            board[row][col] = '_';
            n++;
        }

        // Skip this cell, we place a '_'
        helper(board, row, col + 1, n);
    }

    private static List<String> toString(char[][] board) {
        List<String> list = new LinkedList<>();
        StringBuilder str;
        for (char[] cs : board) {
            str = new StringBuilder();
            for (char cur : cs) {
                str.append(cur);
            }
            list.add(str.toString());
        }
        return list;
    }

    private static boolean isValid(char[][] board, int row, int col) {
        int N = board.length;
        // TOP AND DOWN
        for (int i = 0; i < N; i++) {
            if (board[i][col] != '_')
                return false;
            if (board[row][i] != '_')
                return false;
        }
        // Top left + top right + down left + down right
        int i = row, j = col;
        // Top left
        while (0 <= i && 0 <= j) {
            if (board[i][j] != '_')
                return false;
            i--;
            j--;
        }
        // Top right
        i = row;
        j = col;
        while (0 <= i && j < N) {
            if (board[i][j] != '_')
                return false;
            i--;
            j++;
        }
        // Down Right
        i = row;
        j = col;
        while (i < N && j < N) {
            if (board[i][j] != '_')
                return false;
            i++;
            j++;
        }
        // Down left
        i = row;
        j = col;
        while (i < N && 0 <= j) {
            if (board[i][j] != '_')
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
