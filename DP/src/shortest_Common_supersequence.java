public class shortest_Common_supersequence {
    public static int lcs(String x,String y,int n,int m)
    {
        if (n == 0 || m == 0)
        {
            return 0;
        }
        else if (x.charAt(n-1) == y.charAt(m-1))
        {
            return 1 + lcs(x,y,n-1,m-1);
        }
        else
        {
            return Math.max(lcs(x,y,n-1,m),lcs(x,y,n,m-1));
        }
    }
    public static int scs(String x,String y)
    {
        int a = x.length();
        int b = y.length();
        int l = lcs(x,y,a,b);
        return a+b-l;
    }
    public static void main(String[] args) {
        String x = "geek";
        String y = "eke";
        System.out.println(scs(x,y));
    }
}
