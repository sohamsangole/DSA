import java.util.Stack;

public class check_whether_LinkedList_is_palindrome {
    static class node{
        private int data;
        public node next;
        public node(int n){
            this.data = n;
        }
    }
    public static void printList(node n){
        node curr = n;
        while (curr != null){
            System.out.print(curr.data);
            if (curr.next != null){
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static boolean isPalindrome(node n){
        Stack<node> stack = new Stack<>();
        node curr = n;
        while (curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        node curr2 = n;
        while (curr2 != null){
            node t = stack.pop();
            if (t.data != curr2.data){
                return false;
            }
            curr2 = curr2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        node n = new node(1);
        n.next = new node(2);
        n.next.next = new node(3);
        n.next.next.next = new node(2);
        n.next.next.next.next = new node(1);
        printList(n);
        System.out.println(isPalindrome(n));
    }
}
