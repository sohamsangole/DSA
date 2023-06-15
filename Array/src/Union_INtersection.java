import java.util.ArrayList;

/*
You have been given two arrays/list 'ARR1' and 'ARR2' consisting
of 'N' and 'M' integers respectively. Your task is to return the
number of elements common to 'ARR1' and 'ARR2' and the
number of elements in the union of 'ARR1' and 'ARR2'.
 */
public class Union_INtersection {
    public static ArrayList<Integer> findSimilarity(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m) {
        // Write your code here.

        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0;i < arr1.size();i++)
        {
            if (arr2.contains(arr1.get(i)))
            {
                a.add(1);
            }
        }
        int ansInt = a.size();

        ArrayList<Integer> b = new ArrayList<>();
        b.addAll(arr1);
        b.addAll(arr2);
        int ansUni = b.size() - ansInt;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(ansInt);
        ans.add(ansUni);
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(6);
        b.add(5);

        System.out.println(findSimilarity(a,b,a.size(),b.size()));
    }
}
