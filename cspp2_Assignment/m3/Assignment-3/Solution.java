import java.util.Scanner;
/**
* @author : Rohithmarktricks.
* Date : 29th August 2018.
*/
public class Solution {
    /**
    * class Solution.
    */
    protected Solution() {
        //empty Solution constructor.
    }
    /**
    * @param args of string type.
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        final int n1 = s.nextInt();
        final int n2 = s.nextInt();
        System.out.println(gcd(n1, n2));
    }
    /**
    * @param x int input.
    * @param y int input.
    * @return int type
    */
    public static int gcd(final int x, final int y) {
        ///int min = x < y ? x : y;
        int min = 0;
        if (x > y) {
            min = y;
        } else {
            min = x;
        }
        for (int i = min; i >= 1; i--) {
            if (x % i == 0 & y % i == 0) {
                return i;
            }
        }
        return 1;
    }
}

