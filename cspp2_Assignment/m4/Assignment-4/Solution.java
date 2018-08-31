import java.util.Scanner;
/**
 * class for Solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {
        //empty Constructor.
    }
    /**
     * Main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);

    }
    /**
     * reverseString method definition.
     *
     * @param      str   The string.
     *
     * @return     newStr.
     */
    static String reverseString(final String str) {
        String newStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            newStr += str.charAt(i);
        }
        return newStr;
    }

}
