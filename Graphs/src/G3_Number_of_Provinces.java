import java.util.ArrayList;
// province is basically a component

// nodes start from 1 to n
public class G3_Number_of_Provinces {
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
    public static int numOfProvince(ArrayList<ArrayList<Integer>> adj,boolean[] vis)
    {
        int n = 0;
        for (int i = 1;i<adj.size();i++)
        {
            if (!vis[i]){
                DFS(i,vis,adj,new ArrayList<>());
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

//        // 0
        ArrayList<Integer> z = new ArrayList<>();

        //1
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(4);

        //2
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(3);

        //3
        ArrayList<Integer> c = new ArrayList<>();
        c.add(2);
        c.add(4);

        // 4
        ArrayList<Integer> d = new ArrayList<>();
        d.add(1);
        d.add(3);

        // 5
        ArrayList<Integer> e = new ArrayList<>();
        e.add(6);

        // 6
        ArrayList<Integer> f = new ArrayList<>();
        f.add(5);
        f.add(7);

        // 7
        ArrayList<Integer> g = new ArrayList<>();
        g.add(6);

        // 8
        ArrayList<Integer> h = new ArrayList<>();
        h.add(9);

        // 9
        ArrayList<Integer> i = new ArrayList<>();
        i.add(8);

        // 10
        ArrayList<Integer> j = new ArrayList<>();
        j.add(10);

        adj.add(z);
        adj.add(a);
        adj.add(b);
        adj.add(c);
        adj.add(d);
        adj.add(e);
        adj.add(f);
        adj.add(g);
        adj.add(h);
        adj.add(i);
        adj.add(j);

        System.out.println(adj);
        System.out.println(numOfProvince(adj,new boolean[adj.size()]));
    }
}
