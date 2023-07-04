public class print_n_to_1 {
    public static void func(int n)
    {
        if (n==1)
        {
            System.out.print(1 + " ");
            return;
        }
        System.out.print(n + " ");
        func(n-1);
    }
    public static void main(String[] args) {
        func(10);
    }
}
