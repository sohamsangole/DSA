import java.util.Comparator;
import java.util.PriorityQueue;

public class k_th_Largest_Element {
    public static int kthLargest(int[] arr,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0;i<arr.length;i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        System.out.println(kthLargest(arr,1));
        System.out.println(kthLargest(arr,2));
        System.out.println(kthLargest(arr,3));
        System.out.println(kthLargest(arr,4));
        System.out.println(kthLargest(arr,5));
    }
}
