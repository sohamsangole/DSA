import java.util.Stack;

public class reverse_a_stack {
        public static Stack<Integer> putLast(Stack<Integer> stack,int num)
        {
            if (stack.size() == 0) {
                stack.push(num);
                return stack;
            }
            if (stack.size() == 1) {
                int temp = stack.pop();
                stack.push(num);
                stack.push(temp);
                return stack;
            }
            int x = stack.pop();
            putLast(stack,num);
            stack.push(x);
            return stack;
        }
    public static Stack<Integer> reverseStack(Stack<Integer> stack){
        if (stack.size() == 1)
        {
            return stack;
        }
        int x = stack.pop();
        reverseStack(stack);
        int temp = stack.pop();
        putLast(stack,x);
        stack.push(temp);

        return stack;
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);
//        System.out.println(putLast(stack,0));
        System.out.println(reverseStack(stack));
    }
}
