import java.util.Arrays;

public class coin_change_2 {
    public static int coinChange2(int[] coin,int sum)
    {
        Arrays.sort(coin);
        int[][] t = new int[coin.length+1][sum+1];
        for (int i = 0;i <= coin.length;i++)
            t[i][0] = 0;
        for (int i = 1;i <= sum;i++)
            t[0][i] = -1;

        for (int i = 1;i <= sum;i++)
        {
            if (i%coin[0] == 0)
            {
                t[1][i] = i/coin[0];
            }
            else
            {
                t[1][i] = -1;
            }
        }
        for (int i = 2;i<=coin.length;i++)
        {
            for (int j = 1;j<=sum;j++)
            {
                if (coin[i-1]<=j)
                {
                    t[i][j] = Math.min(1+t[i][j-coin[i-1]],t[i-1][j]);
                }
                else
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[coin.length][sum];
    }
    public static int recCoinChange2(int[] coin,int sum,int n)
    {
        Arrays.sort(coin);
        if (sum == 0)
            return 0;
        if (n == 0)
            return -1;
        if (n == 1)
        {
            if (sum%coin[0] == 0)
                return sum/coin[0];
            else
                return -1;
        }

        if (coin[n-1]>sum)
            return recCoinChange2(coin,sum,n-1);
        else
            return Math.min(1+recCoinChange2(coin,sum-coin[n-1],n),recCoinChange2(coin,sum,n-1));
    }

    public static void main(String[] args) {

        int[] coin = {1,2,3};
        int sum = 5;


        System.out.println(coinChange2(coin,sum));
        System.out.println(recCoinChange2(coin,sum,coin.length));

    }
}
