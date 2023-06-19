import java.util.Arrays;
import java.util.Stack;

class node{
    public int index;
    public int value;
    public node(int a,int b)
    {
        index = a;
        value = b;
    }
}
public class stock_span_problem {
    public static int[] solution(int[] array) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>();
        int[] ans = new int[array.length];

        for (int i = 0; i < array.length; i++)
        {
            while (!stack.isEmpty() && array[stackIndex.peek()] <= array[i])
            {
                stack.pop();
                stackIndex.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = i + 1;
            }
            else {
                ans[i] = i - stackIndex.peek();
            }
            stack.push(i);
            stackIndex.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = { 10, 4, 5, 90, 120, 80 };
        System.out.println(Arrays.toString(solution(a)));

    }
}
