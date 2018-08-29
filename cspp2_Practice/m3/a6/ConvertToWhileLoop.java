/**
* @author Rohithmarktricks
* Date : 29th August 2018
*/
public class ConvertToWhileLoop {
    /**
    * @variable FOUR.
    */
    public static final int TEN = 10;
    /**
    * constructor.
    */
    protected ConvertToWhileLoop() {
        //empty constructor
    }
    /**
    * @param args are of string type from command line.
    */
    public static void main(final String[] args) {
        int i = 2;
        while (i <= TEN) {
            System.out.println(i);
            i += 2;
        }
        System.out.println("GoodBye!");
    }
}
