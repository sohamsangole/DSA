import java.util.HashMap;

public class loop_in_a_LinkedList {
    static class node{
        private int data;
        public node next;
        public node(int n){
            this.data = n;
        }
    }

    // using extra space
    public static boolean detectLoop(node head){
        HashMap<node,Integer> hashMap = new HashMap<>();
        node curr = head;
        while (curr != null){
            if (hashMap.get(curr) != null){
                return true;
            }
            hashMap.put(curr,0);
            curr = curr.next;
        }
        return false;
    }

    // optimized approach

    public static void main(String[] args) {
        node head = new node(1);
        head.next = new node(2);
        head.next.next = new node(3);
        head.next.next.next = new node(4);
        head.next.next.next.next = new node(5);
//        head.next.next.next.next.next =  head.next.next;
        System.out.println(detectLoop(head));
    }
}
