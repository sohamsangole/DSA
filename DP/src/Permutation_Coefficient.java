/**
 * Permutation refers to the process of arranging all the members of a given set to form a sequence.
 * The number of permutations on a set of n elements is given by n! , where “!” represents factorial.
 * The Permutation Coefficient represented by P(n, k) is used to represent the number of ways to obtain
 * an ordered subset having k elements from a set of n elements.
 * Mathematically it’s given as:
 *  P(n,k) = n * n-1 * n-2 * ...... * n-k+1
 */
public class Permutation_Coefficient {
    public static long[][] matrixP(int n,int k){
        long[][]t = new long[n+1][k+1];
        for (int i = 0;i<=n;i++)
            t[i][0] = 1;
        return t;
    }

    public static long nPr(int n,int r){
        long[][] t = matrixP(n,r);
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=r;j++){
                t[i][j] = t[i-1][j] + (j * t[i-1][j-1]);
            }
        }
        return t[n][r];
    }

    public static void main(String[] args) {
        System.out.println(nPr(10,2));
    }
}
