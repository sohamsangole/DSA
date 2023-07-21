public class palindromic_partitioning {
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
    public static int pp(String s,int i,int j) {
        if (i>=j || isPalindrome(s,i,j))
            return 0;
        int minVal = Integer.MAX_VALUE;
        for (int k = i;k<=j-1;k++){
            int tempAns = 1 + pp(s,i,k)+pp(s,k+1,j);
            minVal = Math.min(minVal,tempAns);
        }
        return minVal;
    }

    public static int palindromic(String s)
    {
        return pp(s,0,s.length()-1);
    }

    public static void main(String[] args) {    
        System.out.println(palindromic("aabbaaxmam"));
    }
}
