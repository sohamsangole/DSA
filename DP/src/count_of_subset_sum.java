public class count_of_subset_sum {
    public static int countSubset(int[] arr,int n,int sum)
    {
        if (sum == 0)
        {
            return 1;
        }
        if (n==0 && sum !=0)
        {
            return 0;
        }
        if (arr[n - 1] > sum) {
            return countSubset(arr, n - 1, sum);
        }

        return countSubset(arr, n - 1, sum) + countSubset(arr, n - 1, sum - arr[n - 1]);
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,5,6,8,10};
        int[] arr2= {1, 2, 3, 3};
        System.out.println(countSubset(arr1, arr1.length,10));
        System.out.println(countSubset(arr2, arr2.length,6));
    }
}
