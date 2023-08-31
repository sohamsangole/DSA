import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G10_Bipartite_Graph {
    public static boolean check(int startIndex, int V, ArrayList<ArrayList<Integer>> adj,int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(startIndex);
        color[startIndex] = 0;
        while (!q.isEmpty()){
            int index = q.remove();
            for (int node: adj.get(index)){
                if (color[node] == -1){
                    color[node] = 1 - color[index];
                    q.add(node);
                }
                else if(color[node] == color[index]){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartite(int V,ArrayList<ArrayList<Integer>> adj){
        int[] Color =  new int[adj.size()];
        for (int i = 0;i< Color.length;i++)
            Color[i] = -1;

        for (int i = 0;i<V;i++){
            if (!check(i,V,adj,Color)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
