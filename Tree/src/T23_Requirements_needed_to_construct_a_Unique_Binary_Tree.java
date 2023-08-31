import java.util.*;

public class T23_Requirements_needed_to_construct_a_Unique_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.val = k;
        }
    }

    public static TreeNode buildTree(int[] preOrder,int[] inOrder){
        Map<Integer,Integer> inMap = new HashMap<>();
        for (int i = 0;i<inOrder.length;i++){
            inMap.put(inOrder[i], i);
        }
        return build(preOrder,0, preOrder.length-1,inOrder,0,inOrder.length-1,inMap);
    }
    public static TreeNode build(int[] preOrder,int preStart,int preEnd,
                          int[] inOrder,int inStart,int inEnd,
                          Map<Integer,Integer> inMap){
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);

        int inRoot = inMap.get(root.val);
        int numLeft = inRoot-inStart;
        root.left = build(preOrder,preStart+1,preStart+numLeft,inOrder,inStart,inRoot-1,inMap);
        root.right = build(preOrder,preStart+numLeft+1,preEnd,inOrder,inRoot+1,inEnd,inMap);
        return root;
    }
    public static List<List<Integer>> levelOrder(TreeNode n){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if (n==null){
            return list;
        }
        queue.offer(n);
        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0;i<levelNum;i++){
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            list.add(subList);
        }
        return list;
    }
    public static void main(String[] args) {
        int[] inOrder = {40,20,50,10,60,30};
        int[] preOrder = {10,20,40,50,30,60};
        TreeNode root = buildTree(preOrder,inOrder);
        System.out.println(levelOrder(root));
    }
}
