import java.util.Scanner;
/**
* @author Rohithmarktricks
* Date : 28th August 2018
*/
public final class Solution {
    /**
    * constructor.
    */

    protected Solution() {
        //empty constructor
    }

    /**
    * @param args is of string type: value taken from command prompt
    *
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Name and Rollnumber");
        String name = sc.nextLine();
        String roll = sc.nextLine();
        System.out.println("Name : " + name + " , " + "Roll Number : " + roll);
    }
}
