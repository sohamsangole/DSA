public class matrix_chain_multiplication {
    public static int logic(int[] arr,int i,int j)
    {
        if (i>=j)
            return 0;
        int minVal = Integer.MAX_VALUE;
        for (int k = i;k<=j-1;k++)
        {
            int tempAns = logic(arr,i,k) + logic(arr,k+1,j) + (arr[i-1]*arr[k]*arr[j]);
            if (tempAns<minVal)
            {
                minVal = tempAns;
            }
        }
        return minVal;
    }
    public static int mcm(int[]arr)
    {
        return logic(arr,1, arr.length-1);
    }

    public static void main(String[] args) {
        int [] arr1 = {40, 20, 30, 10, 30};
        int [] arr2 = {1, 2, 3, 4, 3};
        System.out.println(mcm(arr1));
        System.out.println(mcm(arr2));
    }
}
