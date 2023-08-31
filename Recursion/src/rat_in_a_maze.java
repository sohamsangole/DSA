import java.util.LinkedList;
import java.util.List;

public class rat_in_a_maze {
    public static List<String> findPath(int[][] grid){
        List<String> list = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int[] di = {1,0,0,-1};
        int[] dj = {0,-1,1,0};
        if (grid[0][0] == 1){
            solve(0,0,grid,list,"",vis,di,dj, grid.length);
        }
        return list;
    }
    public static void solve(int i,int j,int[][] grid,List<String> list,String move,
                             boolean[][] vis,int[]di,int[]dj,int n){
        if (i == n-1 && j == n-1){
            list.add(move);
            return;
        }
        String dir = "DLRU";
        for (int index = 0;index<4;index++){
            int newI = i + di[index];
            int newJ = j + dj[index];
            if (newI>=0 && newI<n && newJ>=0 && newJ<n
                    && !vis[newI][newJ] && grid[newI][newJ] == 1){
                vis[newI][newJ] = true;
                solve(newI, newJ, grid, list, move + dir.charAt(index), vis, di, dj, n);
                vis[newI][newJ] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,1,1,1},
                {1,1,0,1,0,1},
                {1,1,1,1,0,1},
                {0,0,0,0,0,1},
                {0,0,0,0,0,1},
                {0,0,0,0,0,1},
        };
        System.out.println(findPath(grid));
    }
}
