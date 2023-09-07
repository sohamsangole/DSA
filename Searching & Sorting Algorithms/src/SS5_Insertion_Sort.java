import java.util.Arrays;

public class SS5_Insertion_Sort {
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for (int i = 1;i<n;i++){
            int temp = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
//            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,10,1,6,2};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
