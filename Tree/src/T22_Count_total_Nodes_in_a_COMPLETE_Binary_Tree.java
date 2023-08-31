import java.rmi.MarshalException;

public class T22_Count_total_Nodes_in_a_COMPLETE_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.val = k;
        }
    }
    public static int countNodes(TreeNode root){
        if (root == null) return 0;

        int leftHeight = getHeightLeft(root);
        int rightHeight = getHeightRight(root);

        if (leftHeight == rightHeight){
            return (int) (Math.pow(2,leftHeight) - 1);
        }
        else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    public static int getHeightLeft(TreeNode root){
        int count = 1;
        while (root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }
    public static int getHeightRight(TreeNode root){
        int count = 1;
        while (root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(5);
        n.right.left = new TreeNode(6);
        n.right.right = new TreeNode(7);
        System.out.println(countNodes(n));
    }

}
