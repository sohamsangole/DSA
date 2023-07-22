import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class T3_PreOrder_InOrder_PostOrder_Traversal_Iterative {
    static class node {
        int data;
        node left;
        node right;
        public node(int k){
            this.data = k;
        }
    }
    public static List<Integer> preOrder(node n){
        Stack<node> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if (n == null) return list;
        stack.push(n);
        while (!stack.isEmpty()){
            node temp = stack.pop();
            list.add(temp.data);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return list;
    }
    public static List<Integer> inOrder(node n){
        Stack<node> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if (n == null) return list;
        node  temp = n;
        while (true){
            if (temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            else {
                if (stack.isEmpty()){
                    break;
                }
                temp = stack.pop();
                list.add(temp.data);
                temp = temp.right;
            }
        }
        return list;
    }
    public static List<Integer> postOrder(node n){
        Stack<node> stack1 = new Stack<>();
        Stack<node> stack2 = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if (n == null) return list;
        stack1.push(n);
        while (!stack1.isEmpty()){
            n = stack1.pop();
            stack2.add(n);
            if (n.left!=null) stack1.push(n.left);
            if (n.right!=null) stack1.push(n.right);
        }
        while (!stack2.isEmpty())
        {
            list.add(stack2.pop().data);
        }
        return list;
    }
    public static void main(String[] args) {
        node n = new node(1);
        n.left = new node(2);
        n.right = new node(3);
        n.left.left = new node(4);
        n.left.right = new node(5);
        n.right.left = new node(6);
        n.right.right = new node(7);

        //     1
        //  2     3
        // 4 5   6 7


        System.out.println(preOrder(n));
        System.out.println(inOrder(n));
        System.out.println(postOrder(n));
    }
}
