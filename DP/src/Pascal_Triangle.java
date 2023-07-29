import java.util.LinkedList;
import java.util.List;

public class Pascal_Triangle {
    public static List<List<Integer>> logic(int n,List<List<Integer>> list)
    {
        if (n == 1)
        {
            List<Integer> t = new LinkedList<>();
            t.add(1);
            list.add(t);
            return list;
        }
        if (n == 2)
        {
            logic(1,list);
            List<Integer> t = new LinkedList<>();
            t.add(1);
            t.add(1);
            list.add(t);
            return list;
        }
        logic(n-1,list);
        List<Integer> temp = new LinkedList<>();
        temp.add(1);
        for (int i = 0;i<n-2;i++)
        {
            temp.add(list.get(n-2).get(i) + list.get(n-2).get(i+1));
        }
        temp.add(1);
        list.add(temp);
        return list;
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        return logic(numRows,list);
    }

    public static void main(String[] args) {
        System.out.println(logic(4,new LinkedList<>()));
    }
}
