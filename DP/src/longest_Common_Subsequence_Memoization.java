import java.util.Arrays;

public class longest_Common_Subsequence_Memoization {
    public static int[][] matrix(int n,int m)
    {
        int[][] t = new int[n+1][m+1];
        for (int i = 0; i < t.length; i++) {
            Arrays.fill(t[i],-1);
        }
        return t;
    }
    public static int lcs(String x,String y,int n,int m,int[][] t)
    {
        if (n==0||m==0)
        {
            return 0;
        }
        if (t[n][m] != -1)
        {
            return t[n][m];
        }
        if (x.charAt(n-1) == y.charAt(m-1))
        {
            t[n][m] = 1+lcs(x,y,n-1,m-1,t);
            return t[n][m];
        }
        else
        {
            t[n][m] = Math.max(lcs(x,y,n-1,m,t),lcs(x,y,n,m-1,t));
            return t[n][m];
        }
    }
    public static int longestCommonSubsequence(String x,String y,int n,int m)
    {
        int[][] t = matrix(n,m);
        return lcs(x,y,n,m,t);
    }
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        System.out.println(longestCommonSubsequence(x,y,x.length(),y.length()));
    }
}
