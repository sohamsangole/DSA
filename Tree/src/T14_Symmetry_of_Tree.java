public class T14_Symmetry_of_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.val = k;
        }
    }
    public static boolean isSymHelp(TreeNode left,TreeNode right){
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val) return false;
        return isSymHelp(left.left,right.right) && isSymHelp(left.right,right.left);
    }
    public static boolean isSym(TreeNode root){
        return root==null || isSymHelp(root.left,root.right);
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(2);
        n.left.left = new TreeNode(3);
        n.left.right = new TreeNode(4);
        n.right.left = new TreeNode(4);
        n.right.right = new TreeNode(3);
        System.out.println(isSym(n));
    }
}
