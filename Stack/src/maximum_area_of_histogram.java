import java.util.Arrays;
import java.util.Stack;

public class maximum_area_of_histogram {
    public static long getMaxArea(long hist[], long n) {
        Stack<Integer> stack = new Stack<>();
        int tp;
        int i = 0;
        long maxArea = 0;
        while (i < n) {
            if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
                stack.push(i);
                i++;
            } else {
                tp = stack.peek();
                stack.pop();
                long area;
                if (stack.isEmpty()) {
                    area = hist[tp] * i;
                } else {
                    area = hist[tp] * (i - stack.peek() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            tp = stack.peek();
            stack.pop();
            long area;
            if (stack.isEmpty()) {
                area = hist[tp] * i;
            } else {
                area = hist[tp] * (i - stack.peek() - 1);
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        long[] a = {7, 3, 6, 5, 6, 2, 7};
        System.out.println(getMaxArea(a,a.length));
    }
}
