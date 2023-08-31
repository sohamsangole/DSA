import java.util.HashSet;
import java.util.Set;
// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
// solve
public class Main {
    public static long maximumSubarraySum(int[] nums, int k) {
        int maxSum = 0;
        int temp = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < k;i++) {
            temp = temp + nums[i];
            set.add(nums[i]);
        }
        if(set.size()==k)
        {
            maxSum = Math.max(maxSum,temp);
        }
        for (int i = 0;i<nums.length-k;i++){
            temp = temp - nums[i] + nums[i+k];
            if (set.size()==k){
                maxSum = Math.max(maxSum, temp);
                set.remove(nums[i]);
                set.add(nums[i+k]);
            }
            else {
                set.add(nums[i+k]);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,4,2,9,9,9};
        int k = 3;
         System.out.println(maximumSubarraySum(arr,k));
    }
}
