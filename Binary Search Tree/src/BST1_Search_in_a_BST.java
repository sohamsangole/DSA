public class BST1_Search_in_a_BST {
    static class node{
        node left;
        node right;
        int data;
        public node(int k){
            this.data = k;
        }
    }
    public static node search(node root,int k){
        if (root != null && root.data != k){
            if (root.data>k){
                return search(root.left,k);
            }
            else{
                return search(root.right,k);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        node root = new node(8);
        root.left = new node(5);
        root.left.left = new node(4);
        root.left.right = new node(7);
        root.left.right.left = new node(6);
        root.right = new node(12);
        root.right.left = new node(10);
        root.right.right = new node(14);
        root.right.right.left = new node(13);

        System.out.println(search(root,10));
        System.out.println(root.right.left);
    }
}
