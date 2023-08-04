import java.util.*;

public class print_unique_subsequences {
    public static List<String> generate(String input,String output,List<String> list){
        if (input.length() == 0)
        {
            list.add(output);
            return list;
        }
        StringBuilder i = new StringBuilder(input);
        StringBuilder o = new StringBuilder(output);

        String op1 = output;
        String op2 = String.valueOf(o.append(input.charAt(0)));
        String ip = String.valueOf(i.replace(0,1,""));

        generate(ip,op1,list);
        generate(ip,op2,list);
        Collections.sort(list);
        return list;
    }

    public static Set<String> generateUnique(String input, String output, Set<String> list){
        if (input.length() == 0)
        {
            list.add(output);
            return list;
        }
        StringBuilder i = new StringBuilder(input);
        StringBuilder o = new StringBuilder(output);

        String op1 = output;
        String op2 = String.valueOf(o.append(input.charAt(0)));
        String ip = String.valueOf(i.replace(0,1,""));

        generateUnique(ip,op1,list);
        generateUnique(ip,op2,list);


        return list;
    }
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        List<String> l = new LinkedList<>();
        System.out.println(generate("aabc"," ",l));
        System.out.println(generateUnique("aabc"," ",s));
    }
}
