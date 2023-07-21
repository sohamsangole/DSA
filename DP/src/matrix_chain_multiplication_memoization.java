import java.util.Arrays;

public class matrix_chain_multiplication_memoization {
    public static int[][] matrix(int[] arr)
    {
        int[][] t = new int[arr.length][arr.length];
        for (int i = 0;i<t.length;i++){
            Arrays.fill(t[i],-1);
        }
        return t;
    }
    public static int logic(int[] arr,int i,int j,int[][] t)
    {
        if (i>=j)
            return 0;
        if (t[i][j] != -1)
            return t[i][j];
        int minVal = Integer.MAX_VALUE;
        for (int k = i;k<=j-1;k++)
        {
            int tempAns = logic(arr,i,k,t) + logic(arr,k+1,j,t) + (arr[i-1]*arr[k]*arr[j]);
            if (tempAns<minVal)
            {
                minVal = tempAns;
            }
        }
        t[i][j] = minVal;
        return minVal;
    }
    public static int mcm(int[] arr){
        int[][]t = matrix(arr);
        return logic(arr,1, arr.length-1, t);
    }

    public static void main(String[] args) {
        int [] arr1 = {40, 20, 30, 10, 30};
        int [] arr2 = {1, 2, 3, 4, 3};
        System.out.println(mcm(arr1));
        System.out.println(mcm(arr2));
    }
}
