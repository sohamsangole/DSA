import java.util.ArrayList;
import java.util.Comparator;

public class kth_largest_and_smallest {
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
        //Write your code here
        arr.sort(Comparator.naturalOrder());
        int num1 = arr.get(k-1);
        int num2 = arr.get(arr.size()-k);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(num2);
        ans.add(num1);
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        System.out.println(kthSmallLarge(a,a.size(),2));
    }
}
