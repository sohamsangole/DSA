public class minimum_subset_difference {
    public static int minSubsetDiff(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        boolean[][] t = new boolean[nums.length+1][sum+1];
        for (int i = 0; i <= nums.length; i++)
            t[i][0] = true;

        for (int i = 1; i <= sum; i++)
            t[0][1] = false;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                // If i'th element is excluded
                t[i][j] = t[i - 1][j];

                // If i'th element is included
                if (nums[i - 1] <= j)
                    t[i][j] |= t[i - 1][j - nums[i - 1]];
            }
        }
        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--)
        {
            if (t[nums.length][j] == true) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,7};
        int[] arr2 = {1,5,6,11};
        System.out.println(minSubsetDiff(arr1));
        System.out.println(minSubsetDiff(arr2));
    }
}
