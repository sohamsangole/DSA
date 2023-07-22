import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T2_LevelOrder_Traversal {
    static class node {
        int data;
        node left;
        node right;
        public node(int k){
            this.data = k;
        }
    }
    public static List<List<Integer>> levelOrder(node n){
        Queue<node> queue = new LinkedList<node>();
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
                subList.add(queue.poll().data);
            }
            list.add(subList);
        }
        return list;
    }

    public static void main(String[] args) {
        node n = new node(1);
        n.left = new node(2);
        n.right = new node(3);
        n.left.left = new node(4);
        n.left.right = new node(5);
        n.right.left = new node(6);
        n.right.right = new node(7);
        List<List<Integer>> l = levelOrder(n);
        System.out.println(l);
    }
}
