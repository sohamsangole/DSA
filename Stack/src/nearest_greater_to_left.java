import java.util.Arrays;
import java.util.Stack;

public class nearest_greater_to_left {
    public static int[] solution(int[] array){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[array.length];
        int i = 0;
        while (i!= array.length)
        {
            outer:
            if (stack.isEmpty()){
                ans[i] = -1;
                stack.push(array[i]);
                i++;
            }
            else if (stack.peek() > array[i])
            {
                ans[i] = stack.peek();
                stack.push(array[i]);
                i++;
            }
            else if (stack.peek() <= array[i])
            {
                while (stack.peek()<=array[i]){
                    if (!stack.isEmpty())
                    {
                        stack.pop();
                        if (stack.isEmpty())
                        {
                            break outer;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,4};
        int[] b = {3,2,1,8,7};
        System.out.println(Arrays.toString(solution(a)));
        System.out.println(Arrays.toString(solution(b)));
    }
}
