import java.sql.SQLOutput;

public class tower_of_hanoi {
    public static void toh(int n,char source,char destination,char helper){

        if (n==0){
            return;
        }
        toh(n-1,source,helper,destination);
        System.out.println("Moving plate from " + source + " to " + destination);
        toh(n-1,helper,destination,source);
    }

    public static void main(String[] args) {
        toh(3,'A','C','B');
    }
}
