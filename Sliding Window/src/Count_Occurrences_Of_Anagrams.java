// Solve
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Count_Occurrences_Of_Anagrams {
    public static int countAnagrams(String string,String pattern){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        for (char c: pattern.toCharArray()){
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }
        int i = 0;
        int j = 0;
        while (j < string.length()){
            char charI = string.charAt(i);
            char charJ = string.charAt(j);
            if (!hashMap.containsKey(charJ)){
                q.add(charJ);
            }
            if (j-i+i != pattern.length()){
                if (hashMap.containsKey(charJ)){
                    hashMap.put(charJ, hashMap.getOrDefault(charJ,0)-1);
                }
                j++;
            }
            if (j-i+i == pattern.length()){
                if (hashMap.containsKey(charI)){
                    hashMap.put(charI, hashMap.getOrDefault(charI,0)+1);
                }
                else {
                    q.remove();
                }
                if (hashMap.containsKey(charJ)){
                    hashMap.put(charJ, hashMap.getOrDefault(charJ,0)-1);
                }
                i++;
                j++;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        String pattern = "aaba";
        for (char c: pattern.toCharArray()){
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }
    }
}
