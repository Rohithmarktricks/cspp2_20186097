import java.util.Scanner;
/**
 * class for Solution.
 */
public class Solution {
	/**
	 * Main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String reverse = reverseString(s);
		System.out.println(reverse);

	}
	static String reverseString(String str) {
		String newStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			newStr += str.charAt(i);
		}
		return newStr;
	}

}
