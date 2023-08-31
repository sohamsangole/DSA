import java.util.LinkedList;
import java.util.Queue;

/*
        0 1 1 0
        0 1 1 0
        0 0 1 0
        0 0 0 0
        1 1 0 1

        3 islands
 */
public class G4_Number_of_Islands {
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
                    int newRow = row + delRow;
                    int newCol = col + delCol;
                    if (newRow>=0 && newRow<n && newCol>=0 && newCol<m){
                        if (grid[newRow][newCol] == 1 && !vis[newRow][newCol]){
                            vis[newRow][newCol] = true;
                            q.add(new Pair(newRow,newCol));
                        }
                    }
                }
            }
        }
    }
    public static int numIslands(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int num = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0;i < n;i++){
            for (int j = 0; j < m; j++) {
                if ((!vis[i][j]) && grid[i][j] == 1){
                    bfs(i,j,grid,vis);
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1,0},
                {0,1,1,0},
                {0,0,1,0},
                {0,0,0,0},
                {1,1,0,1},
        };
        System.out.println(numIslands(grid));
    }
}