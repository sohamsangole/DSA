// https://leetcode.com/problems/jump-game/
public class jump_game {
    public static boolean canJump(int[] nums) {
        return jump(nums,0);
    }
    public static boolean jump(int[] nums,int index){
        if (index == nums.length-1) return true;
        if (nums[index] == 0){
            return false;
        }
        index = index + nums[index];
        if (index < nums.length){
            return jump(nums,index);
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,0};
        System.out.println(canJump(arr));
    }
}
