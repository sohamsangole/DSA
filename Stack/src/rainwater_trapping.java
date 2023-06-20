import java.util.Arrays;
import java.util.Locale;
import java.util.Stack;

public class rainwater_trapping {
    public static long solution(long[] arr)
    {
        Stack<Long> stack = new Stack<>();
        long[] maxLeft = new long[arr.length];
        long[] maxRight = new long[arr.length];
        int i = 0;
        while (i!= arr.length)
        {
            outer:
            if (stack.isEmpty())
            {
                maxLeft[i] = 0;
                stack.push(arr[i]);
                i++;
            }
            else if (stack.peek()>=arr[i] && stack.peek()!= 0)
            {
                maxLeft[i] = stack.peek();
                i++;
            }
            else
            {
                while (stack.peek()<arr[i] || stack.peek()==0)
                {
                    if (stack.peek()<arr[i] || stack.peek()==0)
                    {
                        stack.pop();
                        if (stack.isEmpty())
                        {
                            break outer;
                        }
                    }
                }
            }
        }
        while (!stack.isEmpty())
        {
            stack.pop();
        }
        i = arr.length-1;
        while (i!= -1)
        {
            outer:
            if (stack.isEmpty())
            {
                maxRight[i] = 0;
                stack.push(arr[i]);
                i--;
            }
            else if (stack.peek()>=arr[i] && stack.peek()!= 0)
            {
                maxRight[i] = stack.peek();
                i--;
            }
            else
            {
                while (stack.peek()<arr[i] || stack.peek()==0)
                {
                    if (stack.peek()<arr[i]|| stack.peek()==0)
                    {
                        stack.pop();
                        if (stack.isEmpty())
                        {
                            break outer;
                        }
                    }
                }
            }
        }
        long[] length_of_water = new long[arr.length];
        for (int j = 1; j < arr.length-1; j++) {
            if (maxLeft[j]<maxRight[j])
            {
                if (maxLeft[j]!=0)
                {
                    length_of_water[j] = maxLeft[j] - arr[j];
                }
            }
            else
            {
                if (maxRight[j]!=0)
                {
                    length_of_water[j] = maxRight[j] - arr[j];
                }
            }
        }
        long area = 0;
        for (int j = 0; j < arr.length; j++) {
            area = area + length_of_water[j];
        }
        return area;
    }

    public static void main(String[] args) {
        long[] a = {3,0,0,2,0,4};
        long[] b = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution(b));
    }
}
