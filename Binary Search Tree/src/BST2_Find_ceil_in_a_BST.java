public class BST2_Find_ceil_in_a_BST {
    static class node{
        node left;
        node right;
        int data;
        public node(int k){
            this.data = k;
        }
    }
    public static int ceil(node root,int k){
        int ceil = -1;
        node temp = root;
        while (temp!=null){
            if (temp.data == k){
                ceil = temp.data;
                return ceil;
            }
            if (k > temp.data){
                temp = temp.right;
            }
            else {
                ceil = temp.data;
                temp = temp.left;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        node root = new node(10);
        root.left = new node(5);
        root.left.left = new node(3);
        root.left.left.left = new node(2);
        root.left.left.right = new node(4);
        root.left.right = new node(6);
        root.left.right.right = new node(9);
        root.right = new node(13);
        root.right.left = new node(11);
        root.right.right = new node(14);

        System.out.println(ceil(root,9));
        System.out.println(ceil(root,11));
        System.out.println(ceil(root,12));
    }
}
