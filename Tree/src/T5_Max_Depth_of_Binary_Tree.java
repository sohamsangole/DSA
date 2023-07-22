public class T5_Max_Depth_of_Binary_Tree {
    static class node {
        int data;
        node left;
        node right;
        public node(int k){
            this.data = k;
        }
    }
    public static int maxDepth(node root){
        if (root == null) return 0;
        return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    public static void main(String[] args) {
        node n = new node(1);
        n.left = new node(2);
        n.right = new node(3);
        n.right.left = new node(4);
        n.right.right = new node(6);
        n.right.left.left = new node(5);

        //     1
        //  2     3
        //      4   6
        //     5
        System.out.println(maxDepth(n));
    }
}
