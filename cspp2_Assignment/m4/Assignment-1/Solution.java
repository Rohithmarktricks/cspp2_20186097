import java.util.*;
/**
* Class for solution.
*/
public class Solution
{
    /**
     * Constructs the object.
     */
    private Solution(){
        //empty Constructor.
    }
    /**
    * @param args are of string type.
    * prints the maximum of array elements. 
    */
    public static void main(final String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        final int size = sc.nextInt();
        int[] num = new int[size];
        for(int i = 0; i < size ; i++) {
            num[i] = sc.nextInt();
            if (max < num[i]){
                max = num[i];
            }
        }
        System.out.println(max);
    }
}
