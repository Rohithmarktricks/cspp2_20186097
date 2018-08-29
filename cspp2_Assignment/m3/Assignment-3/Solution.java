
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1,n2));
    }
    /*
	Need to write the gcd function and print the output.
	*/
    public static int gcd(int x, int y){
        int min = x < y ? x : y;
        for (int i = min; i >= 1; i--){
            if (x % i == 0 & y % i == 0){
                return i;
            }
        }
        return 1;
    }
}
