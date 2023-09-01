import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static class Pair<E,G>{
        public E key;
        public G number;
        public Pair(E k,G n){
            this.key = k;
            this.number = n;
        }
    }
    public static void main(String[] args) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        minHeap.add(6);
//        minHeap.add(10);
//        minHeap.add(9);
//        minHeap.add(8);
//        minHeap.add(7);
//        System.out.println(minHeap.peek());

        PriorityQueue<Pair<Integer,Integer> > minHeap= new PriorityQueue<>(Comparator.comparingInt(a -> a.key));
        minHeap.add(new Pair<>(1,8));
        minHeap.add(new Pair<>(2,7));
        minHeap.add(new Pair<>(3,6));
        minHeap.add(new Pair<>(4,5));

    }
}