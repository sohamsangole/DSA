import java.util.LinkedList;
import java.util.List;
// https://www.youtube.com/watch?v=eyCj_u3PoJE&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=17
public class generate_balanced_parenthesis {
    public static List<String> parenthesis(int open,int close,String output,List<String> list){
        if (open == 0 && close == 0)
        {
            list.add(output);
            return list;
        }
        if (open!=0){
            String op1 = output;
            op1 = op1 + "(";
            parenthesis(open-1,close,op1,list);
        }
        if (close>open){
            String op2 = output;
            op2 = op2 + ")";
            parenthesis(open, close-1, op2, list);
        }
        return list;
    }
    public static List<String> generateParenthesis(int n){
        return parenthesis(n,n,"",new LinkedList<>());
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(5));
    }
}
