import java.util.Stack;

public class Reverse_a_string {
    public static String revString(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length();i++)
        {
            stack.push(s.charAt(i));
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0 ; i < s.length();i++)
        {
            answer.append(stack.pop());
        }

        return String.valueOf(answer);
    }
    public static void main(String[] args) {
        String a = "Soham Sangole";
        System.out.println(revString(a));
    }
}
