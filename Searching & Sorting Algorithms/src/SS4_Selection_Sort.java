import java.util.Arrays;

public class SS4_Selection_Sort {
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0;i<n-1;i++){
            int min = i;
            for (int j = i+1;j<n;j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            if (min != i){
                // Swap
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
//            System.out.println(Arrays.toString(arr) +  " Min : " +arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
