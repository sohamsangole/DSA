import java.util.LinkedList;
import java.util.List;

public class Print_N_bit_binary_numbers_having_more_1_than_0 {
    public static List<String> logic(int n,int one,int zero,String output,List<String> list)
    {
        if (n == 0)
        {
            list.add(output);
            return list;
        }
        else if (one  == 0 && zero == 0)
        {
            String op1 = output;
            op1 = op1 + "1";
            logic(n-1,one+1,zero,op1,list);
        }
        else if (one < zero)
        {
            String op1 = output;
            op1 = op1 + "1";
            logic(n-1,one+1,zero,op1,list);
        }
        else if (one>=zero)
        {
            String op1 = output;
            op1 = op1 + "1";
            logic(n-1,one+1,zero,op1,list);

            String op2 = output;
            op2 = op2 + "0";
            logic(n-1,one,zero+1,op2,list);
        }
        return list;
    }

    public static List<String> NBitBinary(int n){
        return logic(n,0,0,"",new LinkedList<>());
    }

    public static void main(String[] args) {
        System.out.println(NBitBinary(4));
    }
}
