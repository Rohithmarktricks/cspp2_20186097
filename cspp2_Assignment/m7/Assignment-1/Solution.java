import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * takes the string.
     */
    private String str_name;
    /**
     * calculates the length.
     */
    private int length;
    /**
     * Constructs the object.
     *
     * @param      name  The name
     */
    protected InputValidator(final String name) {
        this.str_name = name;
    }
    static final int SIX = 6;
    /**
     * to Validate the string.
     *
     * @return     "true" or "false" based on length of string.
     */
    public String validateData() {
        this.length = str_name.length();
        if (length >= SIX) {
            return "true";
        } else {
            return "false";
        }
    }

}
/**
 * Class for solution.
 */
class Solution {
    /**
     * @param args of the String.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
