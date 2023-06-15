import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(arr[0]);

        char [] arr2 = new char[5];
        System.out.println(arr2[0]);

        String [] arr3 = new String[5];
        System.out.println(arr3[0]);

        // array input
        int [] a = {1,2,3,4,5,6,7,8,9,10};
        Scanner sc = new Scanner(System.in);

//        for (int i = 0;i<a.length;i++)
//        {
//            a[i] = sc.nextInt();
//        }
//        for (int i = 0;i<a.length;i++)
//        {
//            System.out.print(a[i] + " ");
//        }

        System.out.println(Arrays.toString(a));

        int[][] b = new int[3][];
        int[][] b2D = {
                {1,2,3},
                {4,5},
                {6,7,8,9,10}
        };
        System.out.println(Arrays.toString(b2D));

        for (int row = 0;row< b2D.length;row++)
        {
            for (int col = 0;col<b2D[row].length;col++)
            {
                System.out.print(b2D[row][col] + " ");
            }
            System.out.println();
        }

        ArrayList<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        x.add(1);
        System.out.println(x.toString());

    }
}
