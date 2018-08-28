import java.util.Scanner;
/**
* @author Rohithmarktricks
* Date 28th August 2018
*/
public final class Solution {
    /**
    * Do not modify this main function.
    */
    private Solution() {
        //empty constructor.
    }
    /**
    * @param args takes string from command line.
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        System.out.println((long) power(base, exponent));
    }
    /**
    * @param x takes input.
    * @param y takes input.
    * @return power
    */
    public static long power(final int x, final int y) {
        if (y == 1) {
            return x;
        } else if (y == 0) {
            return 1;
        } else {
            return (long) x * power(x, y - 1);
        }
    }
}
