import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {

    /**
     * Constructs the object.
     */
    protected Solution() {
        //empty Constructor.
    }


    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
     * binaryToDecimal method.
     * @param str takes a binary string.
     * @return decimal str.
     */

    final static String binaryToDecimal(final String str) {
        int sum = 0;
        int i = 1;
        for (int j = str.length() - 1; j >= 0; j--) {
            if (str.charAt(j) == '1') {
                sum += i;
                i *= 2;
            } else {
                i *= 2;
            }
        }
        return String.valueOf(sum);
    }
}
