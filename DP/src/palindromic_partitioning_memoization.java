import java.util.Arrays;

public class palindromic_partitioning_memoization {
    public static boolean isPalindrome(String s,int i,int j)
    {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static int[][] matrix(String s)
    {
        int[][] t = new int[s.length()][s.length()];
        for (int m = 0;m < t.length;m++)
        {
            Arrays.fill(t[m],-1);
        }
        return t;
    }
    public static int pp(String s,int i,int j,int[][] t) {
        if (i>=j || isPalindrome(s,i,j))
            return 0;
        if (t[i][j] != -1)
            return t[i][j];
        int minVal = Integer.MAX_VALUE;
        for (int k = i;k<=j-1;k++){
            int tempAns = 1 + pp(s,i,k,t)+pp(s,k+1,j,t);
            minVal = Math.min(minVal,tempAns);
        }
        t[i][j] = minVal;
        return minVal;
    }

    public static int palindromic(String s)
    {
        int[][] t = matrix(s);
        return pp(s,0,s.length()-1,t);
    }

    public static void main(String[] args) {
        System.out.println(palindromic("ajay"));
    }
}
