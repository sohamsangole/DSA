import java.util.*;

public class top_k_frequent_number {
    static class Pair{
        public int key;
        public int number;
        public Pair(int k,int n){
            this.key = k;
            this.number = n;
        }
    }
    public static List<Integer> kFreqNumbers(int[] arr,int k){
        List<Integer> list = new LinkedList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i =  0;i<arr.length;i++){
            hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.key));
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            minHeap.add(new Pair(entry.getValue(),entry.getKey()));
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        while (!minHeap.isEmpty()){
            list.add(minHeap.remove().number);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,3,2,2,4,4,4,4,4};
        System.out.println(kFreqNumbers(arr,2));
    }
}
