import java.util.Scanner;
/**
* @author Rohithmarktricks
* Date 28th August 2018
*/

public final class Solution {
     /**
    * Do not modify this main function.
    */
    private Solution() {
        //empty constructor.
    }
     /**
    * @param args is of string type: value taken from command prompt
    *
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }
     /**
    * @param x,y,z takes input.
    * 
    */
    public static void rootsOfQuadraticEquation(final int x, final int y, final int z){
        double root1 = Math.sqrt(y * y - 4 * x * z);
        double root2 = Math.sqrt(y * y - 4 * x * z);
        int dnm = 2 * x;
        System.out.println((root1 - y) / dnm + " " + (-root2 - y) / dnm);

    }
}
