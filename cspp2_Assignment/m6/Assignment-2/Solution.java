import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author :
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    static final int FIFTY = 50;
    static final int ONEFIFTY = 150;
    static final int TWOFIFTY = 250;
    static final int THREEFIFTY = 350;
    static final int FOURFIFTY = 450;
    static final int FIVEFIFTY = 550;
    static final int ZERO = 0;
    static final int HUNDRED = 100;
    static final int TWOHUNDRED = 200;
    static final int THREEHUNDRED = 300;
    static final int FOURHUNDRED = 400;
    static final int FIVEHUNDRED = 500;
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a,
                final int rows, final int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (a[i][j] < FIFTY) {
                    a[i][j] = ZERO;
                } else if ( a[i][j] >= FIFTY & a[i][j] < ONEFIFTY) {
                    a[i][j] = HUNDRED;
                } else if (a[i][j] >= ONEFIFTY & a[i][j] < TWOFIFTY) {
                    a[i][j] = TWOHUNDRED;
                } else if (a[i][j] >= TWOFIFTY & a[i][j] < THREEFIFTY) {
                    a[i][j] = THREEHUNDRED;
                } else if (a[i][j] >= THREEFIFTY & a[i][j] < FOURFIFTY) {
                    a[i][j] = FOURHUNDRED;
                } else if (a[i][j] >= FOURFIFTY & a[i][j] < FIVEFIFTY) {
                    a[i][j] = FIVEHUNDRED;
                }
            }
        }
        return a;
    }

    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
