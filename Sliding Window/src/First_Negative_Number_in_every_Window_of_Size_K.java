import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class First_Negative_Number_in_every_Window_of_Size_K {
    public static List<Integer> firstNegNum(int[] arr,int k){
        int i = 0;
        int j = 0;
        List<Integer> list = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        while (j <= arr.length-1) {
            if (arr[j] < 0)
                q.add(arr[j]);
            if (j-i+1 != k){
                j++;
            }
            else{
                if (q.size() == 0){
                    list.add(0);
                }
                else {
                    list.add(q.peek());
                    if (arr[i] < 0){
                        q.remove();
                    }
                }
                i++;
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,-1,3,-4,-2,-5,6};
        int k = 3;
        System.out.println(firstNegNum(arr,k));
    }
}

