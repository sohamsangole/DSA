import java.util.Stack;

public class deleting_middle_element_in_a_stack {
    public static Stack<Integer> logic(Stack<Integer> stack , int middleIndex){
        if (middleIndex == 1)
        {
            stack.pop();
            return stack;
        }
        int x = stack.pop();
        logic(stack,middleIndex-1);
        stack.push(x);
        return stack;
    }
    public static Stack<Integer> deleteMiddle(Stack<Integer> stack)
    {
        int middle;
        if (stack.size()%2 == 1)
        {
            middle = (stack.size()+1)/2;
        }
        else
        {
            middle = (stack.size()/2) +1 ;
        }
        return logic(stack,middle);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
//        stack.push(6);
        System.out.println(stack);
        System.out.println(deleteMiddle(stack));
    }
}
