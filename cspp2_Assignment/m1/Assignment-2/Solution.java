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
    * @param y takes input.
    */
    public static void areaOfTriangle(final int x, final int y) {
        int area = (x * y) / 2;
        System.out.println(area);
    }
    /**
    * @param args is of string type: value taken from command prompt
    *
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        areaOfTriangle(base, height);
    }
    /*
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
