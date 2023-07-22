public class T7_Diameter_of_a_Binary_Tree {
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
    public static int diameter(node root){
        if (root == null) return 0;
        int distance =  maxDepth(root.left)+maxDepth(root.right);
        return Math.max(distance,Math.max(diameter(root.left),diameter(root.right)));
    }

    public static void main(String[] args) {
        node n = new node(1);
        n.left = new node(2);
        n.right = new node(3);
        n.right.left = new node(4);
        n.right.right = new node(7);
        n.right.left.left = new node(5);
        n.right.right.right = new node(8);
        n.right.left.left.left = new node(6);
        n.right.right.right.right = new node(9);

        //     1
        //  2     3
        //      4   7
        //    5       8
        //  6           9
        System.out.println(diameter(n));
    }
}
