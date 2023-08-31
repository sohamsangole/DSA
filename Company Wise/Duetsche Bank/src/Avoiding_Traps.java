import java.util.HashMap;

// https://www.geeksforgeeks.org/minimum-length-of-jumps-to-avoid-given-array-of-obstacles/
public class Avoiding_Traps {
    public static int avoidObstacles(int[] obs){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0;i < obs.length;i++){
            hashMap.put(obs[i], 1);
            max = Math.max(max,obs[i]);
        }
        for (int i = 1; i <= max;i++){
            int j;
             // Steps of i
            for (j = i; j <= max; j = j + i) {

                // if there is obstacle, break the loop.
                if (hashMap.containsKey(j))
                    break;
            }

            // If above loop did not break
            if (j > max)
                return i;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] obs = {5,3,6,7,9};
        System.out.println(avoidObstacles(obs));
    }
}
