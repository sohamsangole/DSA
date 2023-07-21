
public class T1_PreOrder_InOrder_PostOrder_Traversal {
    static class node {
        int data;
        node left;
        node right;
        public node(int k){
            this.data = k;
        }
    }

    public static void preOrder(node n){
        if (n == null)
            return;
        System.out.print(n.data + " ");
        preOrder(n.left);
        preOrder(n.right);
    }

    public static void inOrder(node n){
        if (n == null)
            return;
        inOrder(n.left);
        System.out.print(n.data + " ");
        inOrder(n.right);
    }

    public static void postOrder(node n){
        if (n == null)
            return;
        postOrder(n.left);
        postOrder(n.right);
        System.out.print(n.data + " ");
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

        preOrder(n);
        System.out.println();
        inOrder(n);
        System.out.println();
        postOrder(n);
    }
}
