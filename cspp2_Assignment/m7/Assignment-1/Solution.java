import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * takes the string.
     */
    private String strName;
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
        this.strName = name;
        this.length = strName.length();
    }
    /**
     * SIX takes integer 6.
     */
    static final int SIX = 6;
    /**
     * to Validate the string.
     *
     * @return     "true" or "false" based on length of string.
     */
    public boolean validateData() {
        return length >= SIX;
    }

}
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {
        //empty Constructor.
    }
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
