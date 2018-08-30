import java.util.Scanner;
/**
 * @author : Rohithmarktricks.
 * Date : 30th August 2018.
 */
public class FirstLast6 {
    /**
     * sIX is a constant with value = 6.
     */
    private final int sIX = 6;
    /**
     *  FirstLast6 class constructor.
     *
     * @param      arg   The argument: an int array;
     */
    protected  FirstLast6(final int[] arg) {
        if (arg[0] == sIX || arg[arg.length - 1] == sIX) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of elements : ");
        int[] arr = new int[scan.nextInt()];
        System.out.println("Enter the elements : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        FirstLast6 fls = new FirstLast6(arr);
    }
}
