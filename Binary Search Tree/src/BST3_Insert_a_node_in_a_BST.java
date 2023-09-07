import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST3_Insert_a_node_in_a_BST {
    static class node{
        node left;
        node right;
        int data;
        public node(int k){
            this.data = k;
        }
    }
    public static node insert(node root,int k){
        if (root == null){
            return new node(k);
        }
        node curr = root;
        while (true) {
            if (curr.data < k) {
                if (curr.right != null) curr = curr.right;
                else {
                    curr.right = new node(k);
                    break;
                }
            }
            else {
                if (curr.left != null) curr = curr.left;
                else {
                    curr.left = new node(k);
                    break;
                }
            }
        }
        return root;
    }
    public static void levelOrder(node root){
        Queue<node> q = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            node curr = q.remove();
            list.add(curr.data);
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        node root = new node(4);
        root.left = new node(2);
        root.right = new node(7);
        root.left.left = new node(1);
        root.left.right = new node(3);
        levelOrder(root);
        node newRoot = insert(root,5);
        levelOrder(newRoot);
    }
}
