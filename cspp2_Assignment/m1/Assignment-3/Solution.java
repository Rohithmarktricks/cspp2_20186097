import java.util.Scanner;
/**
* @author Rohithmarktricks
* Date : 28th August 2018
*/

public class Solution {
    /**
    * Do not modify this main function.
    */
    protected Solution() {
        //empty constructor
    }
    /**
    * @param x takes input.
    */
    public static void calculateFromDegreesToFarenheit(final double x) {
        double farenheit = (9 * x / 5) + 32;
        System.out.println("farenheit : " + farenheit);
    }
    /**
    * @param args is of string type: value taken from command prompt
    *
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter degreesCelsius : ");
        double degreesCelsius = scan.nextDouble();
        calculateFromDegreesToFarenheit(degreesCelsius);
    }
}
