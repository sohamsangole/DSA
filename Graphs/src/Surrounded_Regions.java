import java.util.Arrays;

public class Surrounded_Regions {
    // Main Logic
    public static void dfs(int row,int col,char[][] grid,boolean[][] vis,int[] delRow,int[] delCol){
        vis[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0;i<4;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if (nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                if (!vis[nrow][ncol] && grid[nrow][ncol] == 'O'){
                    dfs(nrow,ncol,grid,vis,delRow,delCol);
                }
            }
        }
    }

    public static char[][] fill(char[][] grid){
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        //for 1st and last row
        for(int i = 0;i<m;i++){
            if (!vis[0][i] && grid[0][i] == 'O'){
                dfs(0,i,grid,vis,delRow,delCol);
            }
            if (!vis[n-1][i] && grid[n-1][i] == 'O'){
                dfs(n-1,i,grid,vis,delRow,delCol);
            }
        }

        //for 1st and last col
        for(int i = 0;i<n;i++){
            if (!vis[i][0] && grid[i][0] == 'O'){
                dfs(i,0,grid,vis,delRow,delCol);
            }
            if (!vis[i][m-1] && grid[i][m-1] == 'O'){
                dfs(i,m-1,grid,vis,delRow,delCol);
            }
        }

        //changing
        for (int i = 0;i<n;i++){
            for (int j = 0; j <m; j++) {
                if (!vis[i][j] && grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'X','X','X','X'},
                {'X','O','X','X'},
                {'X','O','O','X'},
                {'X','O','X','X'},
                {'X','X','O','O'},
        };
        System.out.println(Arrays.deepToString(fill(grid)));
    }

}
