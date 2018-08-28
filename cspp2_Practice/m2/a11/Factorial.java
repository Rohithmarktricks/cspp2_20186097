import java.util.Scanner;
/**
* @author Rohithmarktricks
* Date 28th August 2018
*/
public final class Factorial {
    /**
    * Do not modify this main function.
    */
    private Factorial() {
        //empty constructor.
    }
    /**
    * @param x takes input.
    * @return value
    */
    public static int fact(final int x) {
        int out;
        if (x == 0) {
            return 1;
        } else if (x == 1) {
            return 1;
        } else {
            out = fact(x - 1) * x;
            return out;
        }
    }
    /**
    * @param args is of string type: value taken from command prompt
    *
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number :");
        int num = scan.nextInt();
        System.out.format("Factorial : %d\n", new Factorial().fact(num));
    }
}
