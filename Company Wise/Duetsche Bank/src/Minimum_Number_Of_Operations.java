import java.util.HashMap;

// https://www.geeksforgeeks.org/minimum-operation-make-elements-equal-array/
public class Minimum_Number_Of_Operations {
    public static int minOperations(int n) {
        int[] arr = new int[n];
        for (int i = 0;i<n;i++){
            arr[i] = (2*i) + 1;
        }
        // Write your code here.
        int m = 0;
        if(n%2 == 0){
            m = (n/2)-1;
        }
        else {
            if(n == 1){
                return 0;
            }
            m = (n-3)/2;
        }
        int sum = 0;
        for(int i = 0;i<=m;i++){
            sum+=(arr[arr.length-i-1]-arr[i])/2;
        }
        return sum;
    }
    public static int minimumOperations(int[] arr){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0;i<arr.length;i++){
            hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0;i< arr.length;i++){
            max = Math.max(max,hashMap.get(arr[i]));
        }
        return arr.length - max;
    }
    public static void main(String[] args) {
        System.out.println(minOperations(6));

        int[] arr = {1,2,3,4,5,1,2,3};
        System.out.println(minimumOperations(arr));
    }
}
