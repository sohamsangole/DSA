/*
Given a set of non-negative integers and a value sum, the task is to check if there is a subset of the given set whose sum is equal to the given sum.

Examples:

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True
Explanation: There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
Explanation: There is no subset that add up to 30.
 */
public class Subset_Sum_Problem {
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
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        System.out.println(subsetSum(arr, arr.length, 30));
    }
}
