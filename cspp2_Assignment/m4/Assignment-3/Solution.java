
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution {


	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//sc.nextLine();
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}

	final static String binaryToDecimal(String str) {
		int sum = 0;
		int i = 1;
		for (int j = str.length() - 1; j >= 0; j--) {
			if (str.charAt(j) == '1') {
				sum += i;
				i *= 2;
			} else {
				i *= 2;
			}
		}
		return String.valueOf(sum);
	}
}