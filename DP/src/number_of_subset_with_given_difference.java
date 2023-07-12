public class number_of_subset_with_given_difference {
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
    public static int numSubset(int[] nums,int d)
    {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        int s1 = (sum+d)/2;
        return countSubset(nums,nums.length,s1);
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,2,3};
        int[] arr2 = {1};
        System.out.println(numSubset(arr1,1));
        System.out.println(numSubset(arr2,2));
    }
}
