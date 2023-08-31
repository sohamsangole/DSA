import java.util.HashMap;

public class T21_Minimum_time_taken_to_BURN_the_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.val = k;
        }
    }

    public static HashMap<TreeNode,TreeNode> markParent(TreeNode root,HashMap<TreeNode,TreeNode> hashMap){
        if (root == null){
            return hashMap;
        }
        hashMap.put(root.left,root);
        hashMap.put(root.right,root);
        markParent(root.left,hashMap);
        markParent(root.right,hashMap);
        return hashMap;
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(40);
        n.left = new TreeNode(10);
        n.right = new TreeNode(20);
        n.left.left = new TreeNode(2);
        n.left.right = new TreeNode(5);
        n.right.left = new TreeNode(30);
        n.right.right = new TreeNode(40);
    }

}
