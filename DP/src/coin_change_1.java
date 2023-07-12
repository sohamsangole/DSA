/**
 * You are given an integer array coins representing coins of different denominations and an integer
 * amount representing a total amount of money.
 * Return the number of combinations that make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 */
public class coin_change_1 {
    public static int coinChange1(int[] coin, int sum)
    {

        int[][] t = new int[coin.length + 1][sum + 1];
        for (int i = 0;i<=sum;i++)
            t[0][i] = 0;
        for (int i = 0;i<=coin.length;i++)
            t[i][0] = 1;
        for (int i = 1; i <= coin.length; i++)
        {
            for (int j = 1; j <= sum; j++)
            {
                // If the current coin value is greater than the sum, exclude it
                if (coin[i - 1] > j)
                {
                    t[i][j] = t[i - 1][j];
                }
                else
                {
                    t[i][j] = t[i][j - coin[i - 1]] + t[i - 1][j];
                }
            }
        }
        return t[coin.length][sum];
    }
    public static int recCoinChange1(int[] coin, int sum,int n)
    {
        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        if (n <= 0)
            return 0;
        else
            return recCoinChange1(coin,sum,n-1) + recCoinChange1(coin, sum - coin[n - 1], n);
    }

    public static void main(String[] args) {
        int[] coin = {1,2,3};
        int sum = 5;
        System.out.println(coinChange1(coin,sum));
        System.out.println(recCoinChange1(coin,sum,coin.length));
    }
}
