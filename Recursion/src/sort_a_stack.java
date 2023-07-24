import java.util.Stack;

public class sort_a_stack {
    public static void sort(Stack<Integer> stack){
        if (stack.size() == 1 || stack.size() == 0) {
            return;
        }
        int x = stack.pop();
        sort(stack);
        if (stack.peek() <= x) {
            stack.push(x);
        }
        else {
            int temp = stack.pop();
            stack.push(x);
            sort(stack);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(8);
        stack.push(5);
        stack.push(4);

        System.out.println(stack.toString());
        sort(stack);
        System.out.println(stack.toString());
    }
}
