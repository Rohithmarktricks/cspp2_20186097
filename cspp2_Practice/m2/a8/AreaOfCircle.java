import java.util.Scanner;
/**
* @author Rohithmarktricks
* Date : 28th August 2018
*/

public class AreaOfCircle {
    /**
    * Do not modify this main function.
    */
    protected AreaOfCircle() {
        //empty constructor
    }
    /**
    * @param x takes input.
    * @return area
    */
    public static double area(final int x) {
        return pi() * x * x;
    }
    /**
    *  takes no input.
    * @return 3.14
    */
    public static double pi() {
        return 22/7;
    }

    /**
    * @param args is of string type: value taken from command prompt
    *
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter radius : ");
        int radius = scan.nextInt();
        System.out.println(area(radius));
    }
}
