import java.util.Scanner;
/**
* @author : Rohithmarktricks
* Date : 28th August 2018
*/
public final class BiggerEqualSmaller {
    /**
    * Do not modify this main function.
    */
    protected BiggerEqualSmaller() {
        //empty constructor.
    }

    /**
    * @param args is of string type: value taken from command prompt
    *
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter varA and VarB");
        int varA = scan.nextInt();
        int varB = scan.nextInt();
        System.out.println(varA > varB ? varA : varB);
    }
}
