public class Equal_Sum_Partition {
    public static int sumOfArray(int[] arr)
    {
        int sum = 0;
        for (int i = 0;i<arr.length;i++)
        {
            sum = sum + arr[i];
        }
        return sum;
    }
    public static boolean subsetSum(int[] arr,int n,int sum)
    {
        if (sum == 0)
        {
            return true;
        }
        if (n==0)
        {
            return false;
        }
        if (arr[n - 1] > sum) {
            return subsetSum(arr, n - 1, sum);
        }

        return subsetSum(arr, n - 1, sum) || subsetSum(arr, n - 1, sum - arr[n - 1]);
    }
    public static boolean canPartition(int[] nums) {
        int sum = sumOfArray(nums);
        if (sum%2 != 0)
        {
            return false;
        }
        else
        {
            return subsetSum(nums,nums.length,sum/2);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,5,11};
        System.out.println(canPartition(arr));
    }
}
