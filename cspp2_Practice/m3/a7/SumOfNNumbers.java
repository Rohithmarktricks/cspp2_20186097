import java.util.Scanner;
/**
* @author Rohithmarktricks.
* Date : 29th August 2018.
*/
public class SumOfNNumbers {
    /**
    * Constructor.
    */
    protected SumOfNNumbers() {
        //empty constructor.
    }
    /**
    * @param args is of string type: value taken from command prompt.
    *
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a natural number :");
        final int lIMIT = sc.nextInt();
        int init = 0;
        int sum = 0;
        while (init <= lIMIT) {
            sum += init;
            init++;
        }
        System.out.println(sum);
}
}
