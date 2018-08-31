import java.util.Scanner;
/**
* @author Rohithmarktricks
* Date : 28th August 2018
*/
public final class DegreesToFarenheit {
    /**
    * constructor.
    */
    protected DegreesToFarenheit() {
        //empty constructor
    }
    /**
    * @param args is of string type: value taken from command prompt
    *
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the temperature in degrees :");
        int temp = sc.nextInt();
        int faren = (9 * temp / 5) + 32;
        System.out.println("Farenheit temperature equivalent :");
        System.out.println(faren);

    }

}
