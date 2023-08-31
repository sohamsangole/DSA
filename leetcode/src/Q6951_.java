import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/contest/weekly-contest-357/problems/find-the-safest-path-in-a-grid/
public class Q6951_ {
    static class Pair{
        int first;
        int second;
        public Pair(int a,int b){
            this.first = a;
            this.second = b;
        }
    }
    public static int maxDis(List<List<Integer>> grid,int i,int j,int maxNumber,List<Pair> ones){
        int num = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int ui = i-1;
        int di = i+1;
        int rj = j+1;
        int lj = j-1;
        if (grid.get(i).get(j) == 1){
            ones.add(new Pair(i,j));
        }
        else{
            for (Pair one : ones) {
                num = Math.abs(i - one.first) + Math.abs(j - one.second);
                minValue = Math.min(minValue, num);
            }
            maxNumber = Math.max(minValue,maxNumber);
        }
        if (ui < grid.size() && ui>0){
            return maxDis(grid,ui,j,maxNumber,ones);
        }
        if (di < grid.size() && di>0){
            return maxDis(grid,di,j,maxNumber,ones);
        }
        if (rj < grid.size() && rj>0){
            return maxDis(grid,i,rj,maxNumber,ones);
        }
        if (lj < grid.size() && lj>0){
            return maxDis(grid,i,lj,maxNumber,ones);
        }
        return maxNumber;
    }
    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        return maxDis(grid,0,0,Integer.MIN_VALUE,new LinkedList<>());
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new LinkedList<>();

        List<Integer> r1 = new LinkedList<>();
        r1.add(0);
        r1.add(0);
        r1.add(1);

        List<Integer> r2 = new LinkedList<>();
        r2.add(0);
        r2.add(0);
        r2.add(0);

        List<Integer> r3 = new LinkedList<>();
        r3.add(0);
        r3.add(0);
        r3.add(0);

        grid.add(r1);
        grid.add(r2);
        grid.add(r3);

        System.out.println(maximumSafenessFactor(grid));
    }
}
