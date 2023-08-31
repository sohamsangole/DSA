import java.util.ArrayList;

public class G2_DFS {
    public static ArrayList<Integer> DFS(int staringIndex, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {
        dfs.add(staringIndex);
        vis[staringIndex] = true;
        for (int i = 0;i<adj.get(staringIndex).size();i++)
        {
            int index = adj.get(staringIndex).get(i);
            if (!vis[index]) {
                DFS(index, vis, adj, dfs);
            }
        }
        return dfs;
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
        b.add(5);
        b.add(6);

        //3
        ArrayList<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(4);
        c.add(7);

        //4
        ArrayList<Integer> d = new ArrayList<>();
        d.add(3);
        d.add(8);

        //5
        ArrayList<Integer> e = new ArrayList<>();
        e.add(2);

        //6
        ArrayList<Integer> f = new ArrayList<>();
        f.add(2);

        //7
        ArrayList<Integer> g = new ArrayList<>();
        g.add(3);
        g.add(8);

        //8
        ArrayList<Integer> h = new ArrayList<>();
        h.add(4);
        h.add(7);

        adj.add(z);
        adj.add(a);
        adj.add(b);
        adj.add(c);
        adj.add(d);
        adj.add(e);
        adj.add(f);
        adj.add(g);
        adj.add(h);

        System.out.println("Adjacency list : " + adj);
        System.out.println(DFS(1, new boolean[9],adj,new ArrayList<>()));
    }
}
