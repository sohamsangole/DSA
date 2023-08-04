import java.util.LinkedList;
import java.util.List;

public class fibonacci {
    public static List<Integer> fibonacci(int number,List<Integer> list){
        if (number == 1)
        {
            list.add(0);
            return list;
        }
        if (number == 2)
        {
            fibonacci(1,list);
            list.add(1);
            return list;
        }
        fibonacci(number-1,list);
        list.add(list.get(list.size()-1) + list.get(list.size()-2));
        return list;
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(8,new LinkedList<>()));
    }
}
