import java.util.Scanner;
/**
 * Do not modify this main function.
 */
public class Solution {
    /**
    * Fill the main function to print the number of 7's between 1 to n.
    */
    protected Solution() {
        // empty constructor.
    }

    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int noSevens = 0;
        for (int i = 0; i <= n; i++) {
            for (char c : String.valueOf(i).toCharArray()) {
                if (c == '7') {
                    noSevens++;
                }
            }
        }
        System.out.println(noSevens);
    }
}
