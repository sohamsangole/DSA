import java.util.List;

public class add_2_numbers_given_as_LinkedList {
    // digits are given in reversed order
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
    public static node addLists(node l1,node l2){
        node d = new node(0);
        node temp = d;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1){
            int sum = 0;
            if (l1!=null){
                sum+=l1.data;
                l1 = l1.next;
            }
            if (l2!=null){
                sum+=l2.data;
                l2 = l2.next;
            }
            sum+=carry;
            carry = sum/10;
            node newNode = new node(sum%10);
            temp.next = newNode;
            temp = temp.next;
        }
        return d.next;
    }

    public static void main(String[] args) {
        node head1 = new node(5);
        head1.next = new node(4);
        head1.next.next = new node(4);

        node head2 = new node(5);
        head2.next = new node(5);
        head2.next.next = new node(5);
        head2.next.next.next = new node(5);

        node head = addLists(head1,head2);
        printList(head);
    }
}
