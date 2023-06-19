import java.util.Arrays;
import java.util.Stack;

public class nearest_smaller_to_right {
    public static int[] solution(int[] array){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[array.length];
        int i = array.length-1;
        while (i!=-1)
        {
            outer:
            if (stack.isEmpty())
            {
                ans[i] = -1;
                stack.push(array[i]);
                i--;
            }
            else if (stack.peek()<array[i]) {
                ans[i] = stack.peek();
                stack.push(array[i]);
                i--;
            }
            else if (stack.peek()>=array[i]) {
                while (stack.peek()>=array[i]) {
                    if (!stack.isEmpty()){
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
        int[] a = {4,5,2,10,8};
        System.out.println(Arrays.toString(solution(a)));
    }
}
