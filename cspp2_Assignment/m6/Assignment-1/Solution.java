import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author :
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * THREE = 3.
     */
    static final int THREE = 3;
    /**
     * NINE = 9.
     */
    static final int NINE = 9;
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
        // write your code here
        for (int i = NINE; i < n; i = i + 2) {
            for (int j = THREE; j <= n; j++) {
                if ((i != j) & (i % j == 0)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}

