public class delete_a_node {
    // u r not given head
    // u won't be given tail as an input
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
    public static void deleteNode(node n){
        node forward = n.next;
        n.data = forward.data;
        n.next = forward.next;
    }

    public static void main(String[] args) {
        node head1 = new node(1);
        head1.next = new node(2);
        head1.next.next = new node(5);
        head1.next.next.next = new node(6);
        printList(head1);
        deleteNode(head1.next.next);
        printList(head1);
    }
}
