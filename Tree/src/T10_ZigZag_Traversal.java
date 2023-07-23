import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T10_ZigZag_Traversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.val = k;
        }
    }
    public static int toggle(int flag){
        if (flag == 1) return 0;
        else return 1;
    }

    public static List<List<Integer>> zigzagTraversal(TreeNode root){
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int flag = 0;
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0;i<size;i++)
                subList.add(0);
            for (int i = 0;i<size;i++){
                TreeNode temp = q.poll();
                if (flag == 0){
                    subList.set(i, temp.val);
                }
                else if (flag == 1){
                    subList.set(size-i-1, temp.val);
                }
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
            flag = toggle(flag);
            list.add(subList);
        }
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

        System.out.println(zigzagTraversal(n));
    }
}
