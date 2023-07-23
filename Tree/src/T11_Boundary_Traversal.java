import java.util.*;

public class T11_Boundary_Traversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.val = k;
        }
    }
    static Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }
    public static List<Integer> leftBoundaryTraversal(TreeNode root){
        List<Integer> subList = new LinkedList<>();
        TreeNode curr = root.left;
        while (curr!=null){
            if (!isLeaf(curr)) subList.add(curr.val);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
        return subList;
    }
    public static List<Integer> rightBoundaryTraversal(TreeNode root){
        List<Integer> subList = new LinkedList<>();
        TreeNode curr = root.right;
        while (curr!=null){
            if (!isLeaf(curr)) subList.add(curr.val);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        return subList;
    }
    static List<Integer> addLeaves(TreeNode root, List<Integer> list) {
        if (isLeaf(root)) {
            list.add(root.val);
        }
        if (root.left != null) addLeaves(root.left, list);
        if (root.right != null) addLeaves(root.right, list);
        return list;
    }
    public static List<Integer> boundaryTraversalAnticlockwise(TreeNode n){
        List<Integer> Boundary = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();

        List<Integer> left = leftBoundaryTraversal(n);
        List<Integer> leaves = addLeaves(n,temp);
        List<Integer> right = rightBoundaryTraversal(n);
        Collections.reverse(right);

        Boundary.add(n.val);
        Boundary.addAll(left);
        Boundary.addAll(leaves);
        Boundary.addAll(right);
        Boundary.add(n.val);

        return Boundary;
    }

    public static List<Integer> boundaryTraversalClockwise(TreeNode n){
        List<Integer> Boundary = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();

        List<Integer> left = leftBoundaryTraversal(n);
        List<Integer> leaves = addLeaves(n,temp);
        List<Integer> right = rightBoundaryTraversal(n);
        Collections.reverse(left);
        Collections.reverse(leaves);

        Boundary.add(n.val);
        Boundary.addAll(right);
        Boundary.addAll(leaves);
        Boundary.addAll(left);
        Boundary.add(n.val);

        return Boundary;
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.left.left = new TreeNode(4);
        n.left.left.right = new TreeNode(6);
        n.left.left.right.left = new TreeNode(8);
        n.left.left.right.right = new TreeNode(9);
        n.right = new TreeNode(3);
        n.right.right = new TreeNode(5);
        n.right.right.left = new TreeNode(7);
        n.right.right.left.left = new TreeNode(10);
        n.right.right.left.right = new TreeNode(11);
        System.out.println(boundaryTraversalAnticlockwise(n));
        System.out.println(boundaryTraversalClockwise(n));
    }
}
