// Input will always be in lower case
public class permutations_with_case_change_1 {
    public static void pwc(String input,String output){
        if (input.length() == 0)
        {
            System.out.print(output + " ");
            return;
        }
        String op1 = output + input.charAt(0);

        String op2 = output + Character.toUpperCase(input.charAt(0));

        StringBuilder ip = new StringBuilder(input);
        ip.delete(0,1);
        String i = String.valueOf(ip);

        pwc(i, op1);
        pwc(i, op2);
    }

    public static void main(String[] args) {
        pwc("ab","");
    }
}
