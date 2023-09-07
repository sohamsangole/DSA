public class find_and_delete_nth_node_from_last{
    static class node{
        private int data;
        public node next;
        public node(int n){
            this.data = n;
        }
    }
    public static int size(node n){
        int size = 0;
        node curr = n;
        while (curr != null){
            size++;
            curr = curr.next;
        }
        return size;
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

    public static void deleteKthFromLast(node n,int k){
        int size = size(n);
        if (k>size){
            System.out.println("Not Valid !");
            return;
        }
        node temp = n;
        for (int i = 0;i<size-k-1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public static void main(String[] args) {
        node n = new node(1);
        n.next = new node(2);
        n.next.next = new node(3);
        n.next.next.next = new node(4);
        n.next.next.next.next = new node(5);
        printList(n);
        deleteKthFromLast(n,4);
        printList(n);
        deleteKthFromLast(n,10);
        printList(n);

    }
}
