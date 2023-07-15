public class longest_palindromic_subsequence {
    public static int lcs(String x,String y,int n,int m)
    {
        int[][]t = new int[n+1][m+1];
        for (int i = 0;i<=n;i++)
            t[i][0] = 0;
        for (int i = 0;i<=m;i++)
            t[0][i] = 0;
        for (int i = 1;i<=n;i++)
        {
            for (int j = 1;j<=m;j++)
            {
                if (x.charAt(i-1) == y.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
            }
        }
        return t[n][m];
    }
    public static int lps(String x)
    {
        StringBuilder y = new StringBuilder();
        for (int i = x.length()-1;i>=0;i--)
        {
            y.append(x.charAt(i));
        }
        return lcs(x,String.valueOf(y),x.length(),x.length());
    }

    public static void main(String[] args) {
        String x = "agbcba";
        System.out.println(lps(x));
    }
}
