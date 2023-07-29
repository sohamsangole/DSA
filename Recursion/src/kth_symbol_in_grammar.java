// n = 1   0
// n = 2   0 1
// n = 3   0 1 1 0
// n = 4   0 1 1 0 1 0 0 1

// 0 -> 0 1
// 1 -> 1 0
public class kth_symbol_in_grammar {
    public static int complement(int x){
        if (x==0) return 1;
        else return 0;
    }
    public static int solve(int n,int k){
        if (n==1 && k == 1) return 0;
        int mid = (int) Math.pow(2,n-2);
        if (k<=mid) return solve(n-1,k);
        else return complement(solve(n-1,k-mid));
    }

    public static void main(String[] args) {
        System.out.println(solve(4,5));
        System.out.println(solve(4,6));
        System.out.println(solve(4,7));
        System.out.println(solve(4,8));
    }
}
