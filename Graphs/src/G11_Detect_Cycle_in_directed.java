import java.util.ArrayList;

public class G11_Detect_Cycle_in_directed {
    public static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] pathVis){
        vis[node] = true;
        pathVis[node] = true;
        for (int i : adj.get(node)){
            if (!vis[i]){
                if (dfsCheck(i,adj,vis,pathVis)){
                    return true;
                } else if (pathVis[i]) {
                    return true;
                }
            }
        }
        pathVis[node] = false;
        return false;
    }
    public static boolean isCyclic(ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[adj.size()];
        boolean[] pathVis = new boolean[adj.size()];
        for (int i = 1;i <= adj.size();i++){
            if (!vis[i]){
                if (dfsCheck(i,adj,vis,pathVis)){
                    return true;
                }
            }
        }
        return false;
    }
}
