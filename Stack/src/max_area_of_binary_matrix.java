import java.util.Stack;

public class max_area_of_binary_matrix {
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
    public static long solution(long[][] arr)
    {
        long[] hist = new long[arr.length];
        long area = 0;
        long max = 0;
        for (int i = 0;i<arr.length;i++)
        {
            for (int j = 0;j<arr[i].length;j++)
            {
                hist[j] = hist[j] + arr[i][j];
                if ((i == arr.length-1) && (arr[i][j] == 0))
                {
                    hist[j] = 0;
                }
            }
            area = getMaxArea(hist, hist.length);
            if (area > max)
            {
                max = area;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        long[][] matrix = {
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0}
        };
        long[][] matrix2 = {
                {1,1,1},
                {0,1,1},
                {1,0,0}
        };
        System.out.println(solution(matrix));
        System.out.println(solution(matrix2));
    }
}
