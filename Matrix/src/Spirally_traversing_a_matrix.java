import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
 */
public class Spirally_traversing_a_matrix {
    public static List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> ans = new ArrayList<>();

        if (matrix.length == 0)
            return ans;

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        int x = 0, y = 0, di = 0;

        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[x][y]);
            seen[x][y] = true;
            int cr = x + dr[di];
            int cc = y + dc[di];

            if (0 <= cr && cr < m && 0 <= cc && cc < n && !seen[cr][cc]) {
                x = cr;
                y = cc;
            }
            else {
                di = (di + 1) % 4;
                x += dr[di];
                y += dc[di];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {10,11,12,5},
                {9,8,7,6}
        };
        System.out.println(spiralOrder(matrix));
    }
}
