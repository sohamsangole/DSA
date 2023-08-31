import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G5_Flood_Fill {
    static class Pair{
        int first;
        int second;

        public Pair(int a,int b){
            this.first = a;
            this.second = b;
        }
    }
    public static void bfs(int r,int c,int[][] grid,boolean[][] vis,int initialColor, int newColor)
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
                    if (Math.abs(delCol-delRow) != 0 && Math.abs(delCol+delRow) != 2){
                        int newRow = row + delRow;
                        int newCol = col + delCol;
                        if (newRow>=0 && newRow<n && newCol>=0 && newCol<m){
                            if (grid[newRow][newCol] == initialColor && !vis[newRow][newCol]){
                                vis[newRow][newCol] = true;
                                grid[newRow][newCol] = newColor;
                                q.add(new Pair(newRow,newCol));
                            }
                        }
                    }
                }
            }
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here
        boolean[][] vis = new boolean[image.length][image[0].length];
        int initialColor = image[sr][sc];
        image[sr][sc] = newColor;
        bfs(sr,sc,image,vis,initialColor,newColor);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int[][] newImage = floodFill(image,1,1,2);
        System.out.println(Arrays.deepToString(newImage));
    }
}
