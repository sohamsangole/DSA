public class minimum_number_of_insertion_deletion_A_to_B {
    public static String minInsDel(String x,String y)
    {
        int n = x.length();
        int m = y.length();
        int[][]t = new int[n+1][m+1];

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
        int l = t[n][m];
        return "Insertion : "+ (m-l) + " Deletion : " + (n-l);
    }

    public static void main(String[] args) {
        String x = "heap";
        String y = "pea";
        System.out.println(minInsDel(x,y));

        String str1 = "geeksforgeeks";
        String str2 = "geeks";
        System.out.println(minInsDel(str1,str2));
    }
}
