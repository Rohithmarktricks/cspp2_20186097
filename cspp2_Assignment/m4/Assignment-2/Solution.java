import java.util.Scanner;
/**
* Fill the main function to print resultant of addition of matrices.
*/
public class Solution {
    /**
    * Constructs the object.
    */
    protected Solution() {
        //empty Constructor.
    }
    /**
     * Main method.
     *
     * @param      args  The arguments.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int[][] arr1 = new int[x][y]; 
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++){
                arr1[i][j] = scan.nextInt();
            }
        }
        int z = scan.nextInt();
        int v = scan.nextInt();
        int[][] arr2 = new int[z][v];
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < v; j++){
                arr2[i][j] = scan.nextInt();
            }
        }
        if (x == z & y == v) {
            int result = 0;
            String temp = "";
            for (int k = 0; k < x; k++) {
                for (int l = 0; l < y; l++){
                    result = arr1[k][l] + arr2[k][l];
                    temp += result + " ";
                }
                temp =temp.trim();
                temp += "\n";
            }
            System.out.println(temp);
        } else {
            System.out.println("not possible");
        }
        //int[][] result = new int[x][y];
}
}
