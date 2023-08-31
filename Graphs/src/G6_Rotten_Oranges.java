import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotten_oranges
 */
public class G6_Rotten_Oranges {
    static class Pair{
        int first;
        int second;

        public Pair(int a,int b){
            this.first = a;
            this.second = b;
        }
    }
    public static void bfs(int r,int c,int[][] grid,boolean[][] vis)
    {
        vis[r][c] = true;
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        q.add(new Pair(r,c));
        while (!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int delRow = -1;delRow<=1;delRow++)
            {
                for (int delCol = -1;delCol <= 1;delCol++)
                {
                    if (Math.abs(delCol-delRow) != 0 && Math.abs(delCol-delRow) != 2){
                        int newRow = row + delRow;
                        int newCol = col + delCol;
                        if (newRow>=0 && newRow<n && newCol>=0 && newCol<m){
                            if (grid[newRow][newCol] == 1 && !vis[newRow][newCol]){
                                grid[newRow][newCol] = 2;
                                q.add(new Pair(newRow,newCol));
                            }
                            vis[newRow][newCol] = true;
                        }
                    }
                }
            }
        }
    }
    public static int orangesRotting(int[][] grid)
    {
        // Code here
        int[][] gridOriginal = new int[grid.length][grid[0].length];
        for (int i = 0; i < gridOriginal.length; ++i) {
            gridOriginal[i] = new int[grid[i].length];
            System.arraycopy(grid[i], 0, gridOriginal[i], 0, gridOriginal[i].length);
        }

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 2){
                    bfs(i,j,grid,vis);
                    num++;
                }
            }
        }
        int changes = 0;
        for (int i = 0; i < gridOriginal.length; i++) {
            for (int j = 0;j<gridOriginal[0].length;j++){
                if (grid[i][j] != gridOriginal[i][j]){
                    changes++;
                }
            }
        }
        if (changes == 0)
            return -1;
        return num;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {0,1,2},
                {0,1,2},
                {2,1,1}
        };

        int[][] grid2 = {
                {1,2},
                {0,2}
        };
        System.out.println(orangesRotting(grid1));
        System.out.println(orangesRotting(grid2));
    }
}
