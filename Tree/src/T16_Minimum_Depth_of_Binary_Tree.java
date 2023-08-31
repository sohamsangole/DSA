public class T16_Minimum_Depth_of_Binary_Tree {
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
        return 1+ Math.min(maxDepth(root.left),maxDepth(root.right));
    }
}
