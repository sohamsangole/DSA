import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G7_Detect_a_Cycle_in_an_Undirected_Graph {
    static class Pair{
        int first;
        int second;
        public Pair(int a,int b){
            this.first = a;
            this.second = b;
        }
    }
    public static boolean checkUsingBFS(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        while (!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for (int adjacentNode: adj.get(node)){
                if (!vis[adjacentNode]){
                    vis[adjacentNode] = true;
                    q.add(new Pair(adjacentNode,node));
                }
                else if (parent != adjacentNode){
                    return true;
                }
            }

        }
        return false;
    }
    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj){
        int V = adj.size()-1;
        boolean[] vis = new boolean[V+1];
        for (int i = 1;i<=V;i++)
        {
            if (!vis[i]){
                if (checkUsingBFS(i, vis,adj)){
                    return true;
                }
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
        System.out.println("Cycle is present : " + isCycle(adj));
    }
}
