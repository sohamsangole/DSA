import java.util.Comparator;
import java.util.PriorityQueue;

public class k_th_Smallest_Element {
    public static int kthSmallest(int[] arr,int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0;i<arr.length;i++){
            if (maxHeap.size()<=k){
                maxHeap.add(arr[i]);
            }
            else {
                maxHeap.remove();
            }
        }
        while (maxHeap.size()>k){
            maxHeap.remove();
        }
        return maxHeap.remove();
    }

    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        int k = 3;
        System.out.println(kthSmallest(arr,k));
    }
}
