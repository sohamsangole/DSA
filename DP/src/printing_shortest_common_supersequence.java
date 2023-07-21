import javax.swing.plaf.metal.MetalTabbedPaneUI;

public class printing_shortest_common_supersequence {
    public static int[][] matrix(String x,String y){
        int n = x.length();
        int m = y.length();

        int[][] t = new int[n+1][m+1];
        for (int i = 0;i<=n;i++)
            t[i][0] = 0;
        for (int i = 0;i<=m;i++)
            t[0][i] = 0;
        for (int i = 1;i<=n;i++)
        {
            for (int j = 1;j<=m;j++)
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
    public static String scs(String x,String y)
    {
        int[][] t = matrix(x,y);

        StringBuilder stringBuilder = new StringBuilder();
        int i = x.length();
        int j = y.length();
        while (i!=0 && j!=0)
        {
            if (x.charAt(i-1) == y.charAt(j-1)){
                stringBuilder.append(x.charAt(i-1));
                i--;
                j--;
            }
            else if (t[i][j-1] > t[i-1][j])
            {
                stringBuilder.append(y.charAt(j-1));
                j--;
            }
            else
            {
                stringBuilder.append(x.charAt(i-1));
                i--;
            }

        }
        while (i!=0)
        {
            stringBuilder.append(x.charAt(i-1));
            i--;
        }
        while (j!=0)
        {
            stringBuilder.append(y.charAt(j-1));
            j--;
        }
        StringBuilder rev = stringBuilder.reverse();
        return String.valueOf(rev);
    }

    public static void main(String[] args) {
        String x = "abac";
        String y = "cab";

        System.out.println(scs(x,y));
    }
}
