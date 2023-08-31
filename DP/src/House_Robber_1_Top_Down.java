public class House_Robber_1_Top_Down {
    public static int rob(int[] nums) {
        int[] matrix = new int[nums.length+1];
        matrix[1] = nums[0];
        for (int i = 2;i < matrix.length;i++){
            matrix[i] = Math.max(matrix[i-1],nums[i-1] + matrix[i-2]);
        }
        return matrix[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,13,1};
        System.out.println(rob(nums));
    }
}
