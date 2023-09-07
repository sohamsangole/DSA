import java.util.Arrays;

public class SS2_Bubble_Sort {
    public static void bubbleSort(int[] arr){
        int swaps = 0;
        int n = arr.length;
        for (int i = 0;i < n-1;i++){
            swaps = 0;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps++;
                }
            }
            if (swaps == 0){
                return;
            }
        }
        System.out.println(swaps);
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
