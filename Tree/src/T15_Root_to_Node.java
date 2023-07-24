import java.util.LinkedList;
import java.util.List;

public class T15_Root_to_Node {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.val = k;
        }
    }
    public static void inOrder(TreeNode n){
        if (n == null)
            return;
        inOrder(n.left);
        System.out.print(n.val + " ");
        inOrder(n.right);
    }
    public static boolean rootToNode(TreeNode root,List<Integer> list,int num){
        if (root == null) {
            return false;
        }
        list.add(root.val);
        if (root.val == num)
            return true;
        if (rootToNode(root.left,list,num) || rootToNode(root.right,list,num))
            return true;
        list.remove(list.size()-1);
        return false;
    }
    public static List<Integer> listRootToNode(TreeNode root,int num)
    {
        List<Integer> list = new LinkedList<>();
        boolean b = rootToNode(root,list,num);
        return list;
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(5);
        n.right.left = new TreeNode(6);
        n.right.right = new TreeNode(7);

        System.out.println(listRootToNode(n,7));

    }
}
