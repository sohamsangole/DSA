import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SS3_Merge_Sort {
    public static void mergeSort(int[] arr,int low,int high){
        if (low<high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
    public static void merge(int[] arr,int low,int mid,int high){
        int left = low;
        int right = mid+1;
        List<Integer> list = new LinkedList<>();
        while (left<=mid && right<=high){
            if (arr[left] < arr[right]){
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
        for (int i = low;i <= high;i++){
            arr[i] = list.get(i-low);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
