public class longest_Common_SubString {
    public static int lcs(String x,String y,int n,int m)
    {
        int[][]t = new int[n+1][m+1];
        int maxLength = 0;
        for (int i = 0;i<=n;i++)
            t[i][0] = 0;
        for (int i = 0;i<=m;i++)
            t[0][i] = 0;
        for (int i = 1;i<=n;i++)
        {
            for (int j = 1;j<=m;j++)
            {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    maxLength = Math.max(maxLength, t[i][j]);
                }
                else
                    t[i][j] = 0;
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String x = "geeksforgeeks";
        String y = "geeksquiz";
        System.out.println(lcs(x,y,x.length(),y.length()));
    }
}
