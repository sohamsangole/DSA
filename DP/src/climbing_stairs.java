// https://leetcode.com/problems/climbing-stairs/
public class climbing_stairs {
    // its solution matches to fibonacci
    public static int climbStairs(int n) {
        int[] ans = new int[1];
        logic(n,ans);
        return ans[0];
    }
    private static void logic(int n,int[] ans){
        if (n == 0){
            ans[0]+=1;
            return;
        }
        if (n>=1){
            logic(n-1,ans);
        }
        if (n>=2){
            logic(n-2,ans);
        }
    }
    public static int fiboSol(int n){
        if (n == 1 || n == 2){
            return n;
        }
        int[] t = new int[n+1];
        t[1] = 1;
        t[2] = 2;
        for (int i = 3;i<=n;i++){
            t[i] = t[i-1] + t[i-2];
        }
        return t[n];
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
        System.out.println(fiboSol(6));
    }
}
