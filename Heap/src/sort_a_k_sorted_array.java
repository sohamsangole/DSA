import java.util.Arrays;
import java.util.PriorityQueue;

public class sort_a_k_sorted_array {
    public static int[] sort(int[] arr,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] sortedArray = new int[arr.length];
        int index = 0;
        for (int i = 0;i< arr.length;i++){
            minHeap.add(arr[i]);
            if (minHeap.size() > k){
                sortedArray[index] = minHeap.remove();
                index++;
            }
        }
        while (index != arr.length){
            sortedArray[index] = minHeap.remove();
            index++;
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] arr = {6,5,3,2,8,10,9};
        System.out.println(Arrays.toString(sort(arr, 3)));
    }
}
