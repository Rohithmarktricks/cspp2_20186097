import java.util.Scanner;
/**
 * @author : Rohithmarktricks.
 * { Concatination}.
 */

public final class Concatinate {
    /**
     * Constructs the object.
     */
    private Concatinate() {
        //empty.
    }
    /**
     * helloName.
     *
     * @param      name  The name
     */
    public static void helloName(final String name) {
        System.out.println("Hello " + name + "!");
    }
    /**
     * Main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name : ");
        String name = scan.nextLine();
        helloName(name);
    }
}
