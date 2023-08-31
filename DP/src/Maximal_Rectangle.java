// https://leetcode.com/problems/maximal-rectangle/
public class Maximal_Rectangle {
    public static int maxRect(char[][] matrix,int i,int j,int sum){
        if (i < 0 || j < 0)
            return sum;
        if (i == 0 && j == 0) {
            if (matrix[i][j] == '1') return 1;
            else return 0;
        }

        return sum;
    }
    public int maximalRectangle(char[][] matrix) {
        return 0;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'0','1','0'},
                {'1','1','1'},
                {'0','1','0'},
                {'0','1','0'},
        };
        System.out.println(maxRect(matrix,matrix.length-1,matrix[0].length-1,0));
    }
}
