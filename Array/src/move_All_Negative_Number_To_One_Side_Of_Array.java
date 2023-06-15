import java.lang.reflect.Array;
import java.util.Arrays;

public class move_All_Negative_Number_To_One_Side_Of_Array {
    /*
    0 1 2 3 4 5 6
    length = 7
    2 -> 4
    length - 1 - i
     */
    public static int[] separateNegativeAndPositive(int[] a) {
        Arrays.sort(a);
        return a;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,-3,4,-5,6,7,-8,-9};
        System.out.println(Arrays.toString(arr));
        separateNegativeAndPositive(arr);
        System.out.println(Arrays.toString(arr));
    }
}
