import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class T13_TopView_And_BottomView_of_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int k){
            this.val = k;
        }
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root, int numX, int numY, List<List<Integer>> list){
        if (root==null) {
            return list;
        }

        List<Integer> temp = new LinkedList<>();
        temp.add(numX);
        temp.add(numY);
        temp.add(root.val);
        list.add(temp);
        if (root.left != null) {
           verticalTraversal(root.left,numX-1,numY+1,list);
        }
        if (root.right != null) {
            verticalTraversal(root.right,numX+1,numY+1,list);
        }
        return list;
    }
    public static List<Integer> topView(TreeNode root) {
        List<List<Integer>> temp = new LinkedList<>();
        List<List<Integer>> list = verticalTraversal(root, 0, 0, temp);

        //For calculating number of columns
        // As the first column number will be present in first element and the last in last
        list.sort(Comparator.comparing(l -> l.get(0)));

        int numColumns = list.get(list.size()-1).get(0)- list.get(0).get(0) + 1 ;

        // This ensures proper row wise insertion
        list.sort(Comparator.comparing(l -> l.get(1)));

        List<List<Integer>> ansList = new LinkedList<>();
        int a = (numColumns-1)/2;
        int b = -a;
        List<Integer> t = new LinkedList<>();
        for (int i = b;i<=a;i++)
        {
            loop:
            for (int j = 0;j<list.size();j++)
            {
                if (list.get(j).get(0) == i){
                    t.add(list.get(j).get(2));
                    break loop;
                }
            }
        }
        return t;
    }
    public static List<Integer> bottomView(TreeNode root) {
        List<List<Integer>> temp = new LinkedList<>();
        List<List<Integer>> list = verticalTraversal(root, 0, 0, temp);

        //For calculating number of columns
        // As the first column number will be present in first element and the last in last
        list.sort(Comparator.comparing(l -> l.get(0)));

        int numColumns = list.get(list.size()-1).get(0)- list.get(0).get(0) + 1 ;

        // This ensures proper row wise insertion
        list.sort(Comparator.comparing(l -> l.get(1)));

        List<List<Integer>> ansList = new LinkedList<>();
        int a = (numColumns-1)/2;
        int b = -a;
        List<Integer> t = new LinkedList<>();
        for (int i = b;i<=a;i++)
        {
            loop:
            for (int j = list.size()-1;j>=0;j--)
            {
                if (list.get(j).get(0) == i){
                    t.add(list.get(j).get(2));
                    break loop;
                }
            }
        }
        return t;
    }
    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(5);
        n.right.left = new TreeNode(6);
        n.right.right = new TreeNode(7);

        System.out.println(topView(n));
        System.out.println(bottomView(n));
    }
}
