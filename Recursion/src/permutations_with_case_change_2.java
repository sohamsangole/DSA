// Correct the code
// Output is repeating
public class permutations_with_case_change_2 {
    public static void pwc(String input,String output){
        if (input.length() == 0)
        {
            System.out.print(output + " ");
            return;
        }
        String op1;
        String op2;
        if (!Character.isDigit(input.charAt(0))){
            op1 = output + input.charAt(0);
            op2 = output + Character.toUpperCase(input.charAt(0));
        }
        else {
            op1 = output + input.charAt(0);
            op2 = op1;
        }

        StringBuilder ip = new StringBuilder(input);
        ip.delete(0,1);
        String i = String.valueOf(ip);

        pwc(i, op1);
        pwc(i, op2);
    }

    public static void main(String[] args) {
        pwc("a1","");
    }
}
