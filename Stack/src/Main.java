import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Stack<Integer> s =  new Stack<>();
        s.push(10);
        s.push(9);
        s.push(8);
        s.push(7);
        s.push(6);
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println(s.toString());
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        System.out.println(s.toString());

    }
}