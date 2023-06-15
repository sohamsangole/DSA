import java.util.Arrays;

public class Reverse_An_Array {
    public static void revArray(int[] array,int start,int end)
    {
        while(start<end)
        {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(a));

        revArray(a,0,a.length-1);

        System.out.println(Arrays.toString(a));
    }
}
