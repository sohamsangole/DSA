//https://leetcode.com/problems/house-robber/
public class House_Robber_1_Rec {
    public static int maxSum(int[] nums,int size,int sum){
        if (size == 1){
            sum+=nums[0];
            return sum;
        }
        if (size == 2){
            return Math.max(nums[size-1],maxSum(nums,size-1,sum));
        }
        int a = nums[size-1] + maxSum(nums,size-2,sum);
        int b = maxSum(nums,size-1,sum);
        return Math.max(a,b);
    }
    public static int rob(int[] nums) {
        return maxSum(nums, nums.length,0);
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,13,1};
        int[] nums2 = {10,1,1,9};
        System.out.println(maxSum(nums, nums.length,0));
        System.out.println(maxSum(nums2, nums2.length,0));
    }
}
