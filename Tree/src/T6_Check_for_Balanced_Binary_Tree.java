public class T6_Check_for_Balanced_Binary_Tree {
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
    public static boolean checkBBT(node root){
        if (root == null) return true;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        if (Math.abs(lh-rh) >1)
            return false;
        boolean a = checkBBT(root.left);
        boolean b = checkBBT(root.right);
        return a && b;
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
        System.out.println(checkBBT(n));
    }
}
