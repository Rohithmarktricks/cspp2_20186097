import java.util.Scanner;
/**
* Do not modify this main function.
*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    /**
    * @param args are of type:String
    */
    public static void main(final String[] args) {
        Scanner s=new Scanner(System.in);
        int n = s.nextInt();
        int no_sevens = 0;
        for (int i = 0; i <= n; i++){
        	for (char c : String.valueOf(i).toCharArray()){
        		if(c == '7') no_sevens++;
        	}
        }
        System.out.println(no_sevens);    
    }
}
