import java.util.Arrays;

public class array {
    public static void main(String[] args) {
        int[][] t = new int[5][5];
        for (int i = 0; i < t.length; i++) {
            Arrays.fill(t[i],-1);
        }
        for (int i = 0;i<t.length;i++)
        {
            for (int j = 0;j<t[i].length;j++)
            {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }
}
