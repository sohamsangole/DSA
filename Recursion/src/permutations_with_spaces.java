public class permutations_with_spaces {
    public static void pwc(String input,String output){
        if (input.length() == 0)
        {
            System.out.print(output + " ");
            return;
        }
        String op1 = output + input.charAt(0);

        String op2 = output + "_" + input.charAt(0);

        StringBuilder ip = new StringBuilder(input);
        ip.delete(0,1);
        String i = String.valueOf(ip);

        pwc(i, op1);
        pwc(i, op2);
    }

    public static void permutationWithSpaces(String input,String output)
    {
        output = output + input.charAt(0);
        StringBuilder i = new StringBuilder(input);
        i.delete(0,1);
        input = String.valueOf(i);
        pwc(input,output);
    }
    public static void main(String[] args) {
        permutationWithSpaces("ab","");
        System.out.println();
        permutationWithSpaces("abc","");
    }
}
