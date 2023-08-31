import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class merge_sort {
    public static void mergeSort(int[] arr,int low,int high){
        if (low == high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    public static void merge(int[] arr,int low,int mid,int high){
        int left = low;
        int right = mid+1;
        List<Integer> list = new LinkedList<>();
        while (left<=mid && right<=high){
            if (arr[left]<=arr[right]){
                list.add(arr[left]);
                left++;
            }
            else{
                list.add(arr[right]);
                right++;
            }
        }
        while (left<=mid){
            list.add(arr[left]);
            left++;
        }
        while (right<=high){
            list.add(arr[right]);
            right++;
        }
        for (int i = low;i< high;i++){
            arr[i] = list.get(i-low);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,4,1,5,2,6};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
