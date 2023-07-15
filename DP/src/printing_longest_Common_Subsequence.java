import java.util.Arrays;

public class printing_longest_Common_Subsequence {
    public static int[][]lcs(String x,String y,int n,int m)
    {
        int[][] t = new int[n+1][m+1];
        for (int i = 0; i <= n;i++)
            t[i][0] = 0;
        for (int i = 0; i <= m;i++)
            t[0][i] = 0;
        for (int i = 1; i <= n;i++)
        {
            for (int j = 1; j <= m;j++)
            {
                if (x.charAt(i-1) == y.charAt(j-1))
                {
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else
                {
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t;
    }
    public static String printLCS(String x, String y) {
        int n = x.length();
        int m = y.length();
        int[][] t = lcs(x, y, n, m);
        int i = n;
        int j = m;
        StringBuilder s = new StringBuilder();
        while ((i != 0) && (j != 0)) {
            if (x.charAt(i-1) == y.charAt(j-1))
            {
                s.append(x.charAt(i-1));
                i--;
                j--;
            }
            else if (t[i][j-1] > t[i-1][j])
            {
                j--;
            }
            else
            {
                i--;
            }
        }
        StringBuilder rev = s.reverse();
        return String.valueOf(rev);
    }
    public static void main(String[] args) {
        String x = "acbcf";
        String y = "abcdaf";
//        int[][] t = lcs(x,y,x.length(),y.length());
//        System.out.println(Arrays.deepToString(t));
        System.out.println(printLCS(x,y));
    }
}
