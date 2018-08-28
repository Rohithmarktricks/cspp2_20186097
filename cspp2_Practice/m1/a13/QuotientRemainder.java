import java.util.Scanner;
/**
* @author : Rohithmarktricks
* Date : 28th August 2018
*/
public final class QuotientRemainder {
    /**
    * constructor.
    */
    protected QuotientRemainder() {
        //empty constructor
    }
    /**
    * @param args are of string[] type: Can be given values from command prompt.
    *
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two numbers");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int quotient = num1 / num2;
        int remainder = num1 % num2;
        System.out.println("remainder = " + remainder);
        System.out.println(" quotient = " + quotient);
    }

}
