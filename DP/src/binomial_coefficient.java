public class binomial_coefficient {
    public static long[] matrix(int n)
    {
        return new long[n+1];
    }
    public static long factorial(int n,long[] matrix)
    {
        if (n == 0 || n == 1)
        {
            matrix[0] = 1;
            matrix[1] = 1;
            return 1;
        }
        if (matrix[n] != 0)
            return matrix[n];

        matrix[n] = n * factorial(n-1,matrix);
        return matrix[n];
    }
    public static long nCr(int n, int r)
    {
        // code here
        if(n<r)
            return 0;

        if (r>n/2)
            return nCr(n,n-r);
        long[] t = matrix(n);
        long x = factorial(n,t) / (factorial(n-r,t) * factorial(r,t));
        long temp = (long)Math.pow(10,9) + 7;
        return x%temp;
    }

    public static void main(String[] args) {
        System.out.println(nCr(20,10));
    }
}
