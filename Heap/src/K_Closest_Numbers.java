import java.util.*;

public class K_Closest_Numbers {
    static class Pair{
        public int key;
        public int number;
        public Pair(int k,int n){
            this.key = k;
            this.number = n;
        }
    }
    public static List<Integer> kClosestNum(int[] arr,int k,int x){
        List<Integer> list = new LinkedList<>();
        int[] num = new int[arr.length];
        for (int i = 0;i<arr.length;i++){
            num[i] = Math.abs(arr[i] - x);
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> b.key - a.key);
        for (int i = 0;i<arr.length;i++){
            if (maxHeap.size()<=k){
                maxHeap.add(new Pair(num[i],arr[i]));
            }
            else {
                maxHeap.remove();
            }
        }
        while (maxHeap.size()>k){
            maxHeap.remove();
        }
        while (maxHeap.size() > 0){
            list.add(maxHeap.remove().number);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9};
        int k = 3;
        int x = 7;
        System.out.println(kClosestNum(arr,k,x));
    }
}
