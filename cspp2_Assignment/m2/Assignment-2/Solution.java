import java.util.Scanner;
import java.lang.Math.*;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	public static void rootsOfQuadraticEquation(int x, int y, int z){
		double root1 = Math.sqrt(y*y - 4*x*z);
		double root2 = Math.sqrt(y*y - 4*x*z);
		int dnm = 2 * x;
		System.out.println((root1 - y)/dnm + " " + (-root2 - y)/dnm );

	}
}
