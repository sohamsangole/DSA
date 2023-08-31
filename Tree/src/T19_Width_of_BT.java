import java.util.LinkedList;
import java.util.Queue;

public class T19_Width_of_BT {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.val = k;
        }
    }
    static class Pair{
        TreeNode node;
        int num;
        public Pair(TreeNode n,int k){
            this.node = n;
            this.num = k;
        }
    }

    public static int widthOfTree(TreeNode root){
        if (root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while (!q.isEmpty()){
            int size = q.size();
            int mMin = q.peek().num;
            int first = 0;
            int last = 0;
            for (int i = 0;i<size;i++){
                int currId = q.peek().num - mMin;
                TreeNode node = q.peek().node;
                q.poll();

                if (i == 0) first = currId;
                if (i == size - 1) last = currId;

                if (node.left != null){
                    q.add(new Pair(node.left,2*currId + 1));
                }
                if (node.right != null){
                    q.add(new Pair(node.right,2*currId + 2));
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.left.left = new TreeNode(4);
        n.left.left.left = new TreeNode(6);
        n.right = new TreeNode(3);
        n.right.right = new TreeNode(5);
        n.right.right.right = new TreeNode(7);
        System.out.println(widthOfTree(n));

    }
}
