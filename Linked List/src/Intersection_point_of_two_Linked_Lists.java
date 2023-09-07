import java.util.HashMap;

public class Intersection_point_of_two_Linked_Lists {
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

    public static node intersection(node head1,node head2){
        HashMap<node,Boolean> hashMap = new HashMap<>();
        node h1 = head1;
        while (h1!=null){
            hashMap.put(h1,true);
            h1 = h1.next;
        }
        node h2 = head2;
        while (h2!=null){
            if (hashMap.get(h2) != null && hashMap.get(h2)){
                return h2;
            }
            h2 = h2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        node head1 = new node(4);
        head1.next = new node(1);
        head1.next.next = new node(8);
        head1.next.next.next = new node(4);
        head1.next.next.next.next = new node(5);

        node head2 = new node(5);
        head2.next = new node(6);
        head2.next.next = new node(1);
        head2.next.next.next = head1.next.next;

        printList(head1);
        printList(head2);

        System.out.println(intersection(head1,head2).data);
    }
}
