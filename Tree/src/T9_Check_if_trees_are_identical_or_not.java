import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class T9_Check_if_trees_are_identical_or_not {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.val = k;
        }
    }

    public static boolean checkIfIdentical(TreeNode root1,TreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 != null && root2 != null)
            return root1.val == root2.val && checkIfIdentical(root1.left,root2.left) && checkIfIdentical(root1.right,root2.right);

        return false;
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(1);

        TreeNode m = new TreeNode(1);
        m.right = new TreeNode(1);

        System.out.println(checkIfIdentical(n,m));
    }
}
