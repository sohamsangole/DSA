import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T17_Print_Root_to_Node_Path_in_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.val = k;
        }
    }
    public static boolean getPath(TreeNode root, List<Integer> list,int target){
        if (root == null) return false;
        list.add(root.val);
        if (root.val == target){
            return true;
        }
        if (getPath(root.left,list,target) || getPath(root.right,list,target)){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
    public static List<Integer> pathToNode(TreeNode root,int target){
        List<Integer> list = new LinkedList<>();
        if (root == null){
            return list;
        }
        getPath(root,list,target);
        return list;
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(5);
        n.left.right.left = new TreeNode(6);
        n.left.right.right = new TreeNode(7);
        System.out.println(pathToNode(n,7));
    }
}
