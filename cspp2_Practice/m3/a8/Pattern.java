import java.util.Scanner;
/**
* @author Rohithmarktricks.
* Date : 29th August 2018.
*/
public class Pattern {
    /**
    * class information.
    */
    protected Pattern() {
        //empty constructor.
    }
    /**
    * @param args is of type String, from command prompt.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of lines :");
        final int lIMIT = scan.nextInt();
        for (int i = 1; i <= lIMIT; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.format("%d ", j);
            }
            System.out.println();
        }
    }
}
