/**
 * You are given a number 'N' in the form of a string 'S'.
 * You need to find the smallest number strictly greater than 'N' which is also a palindrome.

 122 -> 131
 1337 -> 1441

 */

public class Next_Smallest_Palindrome {
    public static boolean alreadyPalindrome(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        String rev = String.valueOf(stringBuilder.reverse());
        return rev.equals(s);
    }
    public static String nextSmallest(String num){
        if (alreadyPalindrome(num)){
            int i=Integer.parseInt(num);
            i+=1;
            num = String.valueOf(i);
        }
        if (num.length()%2==0){
            return handleEven(num);
        }
        else{
            return handleOdd(num);
        }

    }
    public static String handleEven(String num){
        int n = num.length();
        String left = "";
        String right = "";
        for (int i = 1;i<=n;i++){
            if (i <= n/2){
                left+=num.charAt(i-1);
            }
            else {
                right+=num.charAt(i-1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(left);
        String revLeft = String.valueOf(stringBuilder.reverse());
        if (Integer.parseInt(revLeft) > Integer.parseInt(right)){
            return left+revLeft;
        }
        else {
            int i = Integer.parseInt(left) + 1;
            left = String.valueOf(i);
            StringBuilder s = new StringBuilder(left);
            String rL = String.valueOf(s.reverse());
            return left+rL;
        }
    }
    public static String handleOdd(String num){
        int n = num.length();
        String left = "";
        String centre = "";
        String right = "";
        for (int i = 1;i<=n;i++){
            if (i < (n+1)/2){
                left+=num.charAt(i-1);
            }
            else if (i > (n+1)/2){
                right+=num.charAt(i-1);
            }
            else {
                centre+=num.charAt(i-1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(left);
        String revLeft = String.valueOf(stringBuilder.reverse());
        if (Integer.parseInt(revLeft)>Integer.parseInt(right)){
            return left + centre + revLeft;
        }
        else {
            left = left + centre;
            int i=Integer.parseInt(left);
            i+=1;
            left = String.valueOf(i);
            StringBuilder s = new StringBuilder(left);
            return left + String.valueOf(s.reverse().deleteCharAt(0));
        }
    }
    public static void main(String[] args) {
        System.out.println(nextSmallest("122"));
        System.out.println(nextSmallest("1337"));
        System.out.println(nextSmallest("13937"));
        System.out.println(nextSmallest("8999"));
    }
}
