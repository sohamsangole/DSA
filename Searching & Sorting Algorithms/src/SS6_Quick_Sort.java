import java.util.Arrays;

public class SS6_Quick_Sort {
    public static void quickSort(int[] arr,int low,int high){
        if (low<high){
            int pivot = partition(arr,low,high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }
    }
    private static int partition(int[] arr,int low,int high){
        int pivot = arr[high];
        int i = low-1;
        for (int j = low;j<high;j++){
            if (arr[j] < pivot){
                i++;
                // Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
//        System.out.println(Arrays.toString(arr));
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {6,3,9,5,2,8};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
