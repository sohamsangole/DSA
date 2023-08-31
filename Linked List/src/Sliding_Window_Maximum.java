import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/sliding-window-maximum/
public class Sliding_Window_Maximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] list = new int[nums.length-k+1];
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        while (j < nums.length){
            if (j-i+1 != k){
                max = Math.max(nums[j],max);
                q.add(nums[j]);
                j++;
            }
            if (j-i+1 == k){
                if (nums[j] > max){
                    max = nums[j];
                }
                q.add(nums[j]);
                list[i] = max;
                if (q.peek() == nums[i]){
                    if (nums[i] == max){
                        q.remove();
                        max = findMax(q);
                    }
                    q.remove();
                }
                i++;
                j++;
            }
        }
        return list;
    }
    private static int findMax(Queue<Integer> q) {
        int max = Integer.MIN_VALUE;
        for (int num : q) {
            max = Math.max(max, num);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] numbers = {1,3,1,2,0,5};
        System.out.println(Arrays.toString(maxSlidingWindow(numbers,3)));
    }
}
