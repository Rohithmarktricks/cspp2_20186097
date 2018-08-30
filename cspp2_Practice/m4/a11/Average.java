import java.util.Scanner;
/**
* { Average Class }.
*/

public class Average {

    /**
     * Constructs the object.
     */
    protected Average() {
        //empty constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        final int size = scan.nextInt();
        int sum = 0;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        for (int j = 0; j < size; j++) {
            sum += arr[j];
        }
        System.out.println((double) sum / size);
    }
}
