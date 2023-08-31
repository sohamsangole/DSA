import java.util.LinkedList;
import java.util.List;
// Solve again
// https://leetcode.com/contest/weekly-contest-357/problems/check-if-it-is-possible-to-split-array/
public class Q6953_Check_if_it_is_Possible_to_Split_Array {
    public static int sumOfListTill(List<Integer> list,int index){
        int sum = 0;
        for (int i = 0;i <= index;i++)
            sum+=list.get(i);
        return sum;
    }
    public static boolean check(List<Integer> list,int m,int first,int last){
        if (first<0 || last< 0 )
            return false;
        if ((first == 0 && last == 0)){
            return true;
        }
        if ((sumOfListTill(list,first-1)>=m) || last==1){
            if (first == last){
                first--;
                last--;
            }
            else {
                first--;
                last = first;
            }
            check(list,m,first,last);
        }
        else if (list.get(first) + list.get(last)>=m && (last-first == 1)) {
            first--;
            last = first;
            check(list,m,first,last);
        }

        else if (sumOfListTill(list,first-1)< m) {
            first--;
            check(list,m,first,last);
        }
        return check(list,m,first,last);
    }

    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>();
        nums.add(2);
        nums.add(1);
        nums.add(1);
        nums.add(3);
        int m = 4;
        System.out.println(check(nums,m,nums.size()-1,nums.size()-1));
    }
}
