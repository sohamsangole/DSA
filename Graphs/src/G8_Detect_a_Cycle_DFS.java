import java.util.ArrayList;

public class G8_Detect_a_Cycle_DFS {
    static class pair{
        public int node;
        public int parent;
        public pair(int n,int p){
            this.node = n;
            this.parent = p;
        }
    }
    public static boolean checkUsingDFS(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int startIndex,int parent){
        vis[startIndex] = true;
        for (int i = 0;i<adj.get(startIndex).size();i++){
            int index = adj.get(startIndex).get(i);
            if (!vis[index]){
                checkUsingDFS(adj,vis,index,startIndex);
            } else if (parent != index) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // 0
        ArrayList<Integer> z = new ArrayList<>();

        // 1
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);

        // 2
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(4);
        b.add(5);

        // 3
        ArrayList<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(4);

        // 4
        ArrayList<Integer> d = new ArrayList<>();
        d.add(2);
        d.add(3);
        d.add(5);

        // 5
        ArrayList<Integer> e = new ArrayList<>();
        e.add(2);
        e.add(4);

        adj.add(z);
        adj.add(a);
        adj.add(b);
        adj.add(c);
        adj.add(d);
        adj.add(e);

        System.out.println("Adjacency list : " + adj);
        System.out.println("Cycle is present : " + checkUsingDFS(adj,new boolean[adj.size()],1,-1));
    }
}
