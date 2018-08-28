import java.util.Scanner;
/**
* @author : Rohithmarktricks.
* Date : 27th August 2018.
* Swap of numbers without using temp variable.
*/

public final class Swap {
    /**
    * constructor.
    */
    private Swap() {
        // default empty constructor
    }

    /**
    * @param args of type str : They store the input from command line
    *
    */

    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the values of a and b :");
        int a = in.nextInt();
        int b = in.nextInt();
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After Swapping");
        System.out.println("a = " + a + " b = " + b);

    }
}
