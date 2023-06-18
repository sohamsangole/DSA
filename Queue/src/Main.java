import java.util.LinkedList;
import java.util.Queue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(9);
        q.add(8);
        q.add(7);
        q.add(6);
        q.add(5);
        q.add(4);
        q.add(3);
        q.add(2);
        q.add(1);
        System.out.println(q.toString());
        q.remove();
        q.remove();
        q.remove();
        q.remove();
        System.out.println(q.toString());
    }
}