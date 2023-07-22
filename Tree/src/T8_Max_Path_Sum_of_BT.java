public class T8_Max_Path_Sum_of_BT {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.data = k;
        }
    }
    public static int maxPathSum(TreeNode root){
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root,maxValue);
        return maxValue[0];
    }
    public static int maxPathDown(TreeNode root,int[] maxValue) {
        if (root == null) return 0;
        int left = Math.max(0,maxPathDown(root.left,maxValue));
        int right = Math.max(0,maxPathDown(root.right,maxValue));
        maxValue[0] = Math.max(maxValue[0],left+right+root.data);
        return root.data + Math.max(left,right);
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(-10);
        n.left = new TreeNode(9);
        n.right = new TreeNode(20);
        n.right.left = new TreeNode(15);
        n.right.right = new TreeNode(7);
        System.out.println(maxPathSum(n));
    }
}
