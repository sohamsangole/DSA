public class merging_2_sorted_ll {
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
    public static node merge(node head1,node head2){
        node head = new node(Integer.MIN_VALUE);
        node h = head;
        node h1 = head1;
        node h2 = head2;
        while (h1!=null && h2!=null){
            if (h1.data < h2.data){
                node temp = new node(h1.data);
                head.next = temp;
                head = head.next;
                h1 = h1.next;
            }
            else{
                node temp = new node(h2.data);
                head.next = temp;
                head = head.next;
                h2 = h2.next;
            }
        }
        while (h1!=null){
            node temp = new node(h1.data);
            head.next = temp;
            head = head.next;
            h1 = h1.next;
        }
        while (h2!=null){
            node temp = new node(h2.data);
            head.next = temp;
            head = head.next;
            h2 = h2.next;
        }
        return h.next;
    }

    public static void main(String[] args) {
        node head1 = new node(1);
        head1.next = new node(2);
        head1.next.next = new node(5);
        head1.next.next.next = new node(6);

        node head2 = new node(1);
        head2.next = new node(3);
        head2.next.next = new node(4);
        head2.next.next.next = new node(5);

        node head = merge(head1,head2);
        printList(head);
    }
}
