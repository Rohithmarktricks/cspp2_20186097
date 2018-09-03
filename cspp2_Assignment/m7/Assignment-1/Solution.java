import java.util.*;
/**
 * Class for input validator.
 */
class InputValidator {
    String name;
    int length;
    /**
     * Constructs the object.
     *
     * @param      name  The name
     */
    protected InputValidator(String name) {
        this.name = name;
        this.length = name.length();
    }
    /**
     * to Validate the string.
     *
     * @return     "true" or "false" based on length of string.
     */
    public String validateData() {
        if ( length == 6) {
            return "true";
        } else {
            return "false";
        }
    }

}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * @param args of the String.
     */
    public static void main(final String args[]) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
