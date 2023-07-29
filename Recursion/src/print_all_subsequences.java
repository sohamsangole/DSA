public class print_all_subsequences {
    public static void solve(String ip,String op)
    {
        if (ip.length() == 0)
        {
            System.out.print(op + " ");
            return;
        }
        String op1 = op;
        StringBuilder s = new StringBuilder(op);
        String op2 = String.valueOf(s.append(ip.charAt(0)));

        StringBuilder t = new StringBuilder(ip);
        ip = String.valueOf(t.replace(0,1,""));
        solve(ip,op1);
        solve(ip,op2);
    }
    public static void main(String[] args) {
//        StringBuilder s = new StringBuilder("ABC");
//        s.replace(0,1,"");
//        System.out.println(s);
        solve("ab","");
        solve("abc","");
    }
}
