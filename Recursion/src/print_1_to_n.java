public class print_1_to_n {
    public static void func(int n)
    {
        if (n==1)
        {
            System.out.print(1 + " ");
            return;
        }
        func(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        func(10);
    }
}
