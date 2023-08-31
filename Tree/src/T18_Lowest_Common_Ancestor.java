import java.util.LinkedList;
import java.util.List;

public class T18_Lowest_Common_Ancestor {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.val = k;
        }
    }
    public static TreeNode lca(TreeNode root,TreeNode a,TreeNode b){
        if (root == null || root == a || root == b){
            return root;
        }
        TreeNode leftNode = lca(root.left,a,b);
        TreeNode rightNode = lca(root.right,a,b);

        if (leftNode == null){
            return rightNode;
        } else if (rightNode == null){
            return leftNode;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.right.left = new TreeNode(4);
        n.right.right = new TreeNode(5);
        n.right.right.left = new TreeNode(6);
        n.right.right.right = new TreeNode(7);
        n.right.left.left = new TreeNode(8);
        System.out.println(lca(n,n.right.right.right,n.right.left.left).val);
    }
}
