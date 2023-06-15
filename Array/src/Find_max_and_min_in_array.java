public class Find_max_and_min_in_array {
    public static int maxArray(int[] array)
    {
        int max = array[0];
        for (int i = 1;i<array.length;i++)
        {
            if (array[i]>max)
            {
                max = array[i];
            }
        }
        return max;
    }
    public static int minArray(int[] array)
    {
        int min = array[0];
        for (int i = 1;i<array.length;i++)
        {
            if (array[i]<min)
            {
                min = array[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] a = {1,-2,3,4,15,6,7,8,9};
        System.out.println("Max = " + maxArray(a));
        System.out.println("Min = " + minArray(a));
    }
}
