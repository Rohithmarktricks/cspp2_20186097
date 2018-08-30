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
     * Creates a matrix.
     *
     * @param      scan  The scan
     *
     * @return     { description_of_the_return_value }
     */
    public static int[][] createMatrix(final Scanner scan) {
        int x = scan.nextInt();
        int y = scan.nextInt();
        int[][] arr1 = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arr1[i][j] = scan.nextInt();
            }
        }
        return arr1;
    }
    /**
     * Main method.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] arr1 = createMatrix(scan);
        int[][] arr2 = createMatrix(scan);
        int x = arr1.length, z = arr2.length;
        int y = arr1[0].length, v = arr2[0].length;
        if (x == z & y == v) {
            int result = 0;
            String temp = "";
            for (int k = 0; k < x; k++) {
                for (int l = 0; l < y; l++) {
                    result = arr1[k][l] + arr2[k][l];
                    temp += result + " ";
                }
                temp = temp.trim();
                temp += "\n";
            }
            System.out.println(temp);
        } else {
            System.out.println("not possible");
        }
    }
}
