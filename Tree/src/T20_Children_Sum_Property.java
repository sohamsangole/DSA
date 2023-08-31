import java.util.LinkedList;
import java.util.List;

public class T20_Children_Sum_Property {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.val = k;
        }
    }

    public static void childSumProp(TreeNode root){
        if (root == null) return;
        int child = 0;
        if (root.left != null) child += root.left.val;
        if (root.right != null) child += root.right.val;

        if (child > root.val){
            root.val = child;
        }
        else {
            if (root.left != null){
                root.left.val = root.val;
            }
            else if (root.right != null){
                root.right.val = root.val;
            }
        }

        childSumProp(root.left);
        childSumProp(root.right);

        int tot = 0;
        if (root.left != null) tot+= root.left.val;
        if (root.right != null) tot+= root.right.val;
        if (root.left != null || root.right != null) root.val = tot;
    }

    public static List<Integer> preOrder(TreeNode root,List<Integer> list){
        if (root == null) return list;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(40);
        n.left = new TreeNode(10);
        n.right = new TreeNode(20);
        n.left.left = new TreeNode(2);
        n.left.right = new TreeNode(5);
        n.right.left = new TreeNode(30);
        n.right.right = new TreeNode(40);

        childSumProp(n);

        System.out.println(preOrder(n,new LinkedList<>()));
    }
}
