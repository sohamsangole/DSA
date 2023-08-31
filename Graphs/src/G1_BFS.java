import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class G1_BFS {
    public static ArrayList<Integer> bfs(int startingNum,int V,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(startingNum);
        vis[startingNum] = true;
        while (!q.isEmpty()) {
            // adding node in bfs
            int node = q.poll();
            bfs.add(node);

            // adding adjacent nodes in q
            for (int i = 0;i<adj.get(node).size();i++){
                if (!vis[adj.get(node).get(i)]){
                    vis[adj.get(node).get(i)] = true;
                    q.add(adj.get(node).get(i));
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

//        // 0
        ArrayList<Integer> z = new ArrayList<>();

        //1
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);

        //2
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(4);
        b.add(5);

        //3
        ArrayList<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(4);

        //4
        ArrayList<Integer> d = new ArrayList<>();
        d.add(2);
        d.add(3);
        d.add(5);

        //5
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
        System.out.println("BFS : " + bfs(5,5,adj));
    }
}
