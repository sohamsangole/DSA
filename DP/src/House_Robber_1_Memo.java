public class House_Robber_1_Memo {
    public static int maxSum(int[] nums,int[] matrix,int size){
        if (size == 1){
            matrix[1] = nums[0];
            return matrix[1];
        }
        if (size == 2){
            matrix[2] =  Math.max(nums[size-1],maxSum(nums,matrix,size-1));
            return matrix[2];
        }
        if (matrix[size-1] == 0){
            matrix[size-1] = maxSum(nums,matrix,size-1);
        }
        if (matrix[size-2] == 0){
            matrix[size-2] = maxSum(nums,matrix,size-2);
        }
        return Math.max(nums[size-1] + matrix[size-2],matrix[size-1]);
    }
    public static int rob(int[] nums) {
        int[] matrix = new int[nums.length+1];
        return maxSum(nums,matrix,nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,13,1};
        System.out.println(rob(nums));
    }
}
