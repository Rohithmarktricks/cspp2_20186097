import java.util.Scanner;
/**
* @author Rohithmarktricks
* Date 28th August 2018
*/
public class Solution {
	/*
	Do not modify this main function.
	*/
	private Solution() {
        //empty constructor.
    }
    /**
    * @param args takes string from command line 
    */
	public static void main(final String[] args) {
		Scanner s=new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        int result=power(base,exponent);
        System.out.println(result);
	}
	/**
    * @param x takes input.
    * @param y takes input.
    * @return power
    */
	public static int power(final int x, final int y){
		if (y == 1){
			return x;
		} else {
			return x*power(x, y-1);
		}
	}
}
