import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G9_Distance_Of_Nearest_having_1 {
    static class node{
        int first;
        int second;
        int third;
        public node(int i,int j,int k){
            this.first = i;
            this.second = j;
            this.third = k;
        }
    }
    public static int[][] nearest(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];
        Queue<node> q = new LinkedList<>();
        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                if (grid[i][j] == 1){
                    q.add(new node(i,j,0));
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while (!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int step =q.peek().third;
            q.remove();

            dis[row][col] = step;

            for (int i = 0;i<delRow.length;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (nRow>=0 && nRow<n && nCol>=0 && nCol<m){
                    if (vis[nRow][nCol] == 0){
                        q.add(new node(nRow,nCol,step+1));
                        vis[nRow][nCol] = 1;
                    }
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,0,1},
                {1,1,0},
                {1,0,0}
        };
        int[][] dis = nearest(grid);
        System.out.println(Arrays.deepToString(dis));
    }
}
