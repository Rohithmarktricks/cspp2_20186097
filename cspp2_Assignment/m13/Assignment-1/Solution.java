import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;


/**
 * Class for set.
 * @author : RohithMarktricks.
 */
class Set {
    /**
     * List.
     */
    private int[] list;
    /**
     * size.
     */
    private int size;
    /**
     * lIMIT.
     */
    private final int lIMIT = 100;
    /**
     * Constructs the object.
     */
    Set() {
        list = new int[lIMIT];
        size = 0;
    }
    /**
     * size of set.
     *
     * @return     size.
     */
    public int size() {
        return size;
    }
    /**
     * adds the item to set.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        list[size] = item;
        size++;
    }
    /**
     * adds the items[] to set.
     *
     * @param      items  The items
     */
    public void add(final int[] items) {
        int flag = 0;
        //int[] temp = Arrays.copyOf(list, list.length);
        for (int j = 0; j <= items.length - 1; j++) {
            flag = 0;
            for (int i = 0; i < list.length; i++) {
                if (items[j] == list[i]) {
                    flag = 1;
                }
            } if (flag == 0) {
                add(items[j]);
            }
        }
    }

    /**
     * Contains.
     *
     * @param      item  The item
     *
     * @return     true/false.
     */
    public boolean contains(final int item) {
        for (int element : list) {
            if (item == element) {
                return true;
            }
        } return false;
    }
    /**
     * retainAll.
     *
     * @param      array  The array
     *
     * @return     Common elements.
     */
    public Set retainAll(final int[] array) {
        Set retain = new Set();
        for (int j = 0; j < this.size(); j++) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == this.list[j]) {
                    retain.add(this.list[j]);
                }
            }
        } return retain;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        // Replace the code below
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        for (int i = 0; i < size - 1; i++) {
            str = str + list[i] + ", ";
        }
        str = str + list[size - 1] + "}";
        return str;
    }
    /**
     * intersection.
     *
     * @param      array  The array
     *
     * @return    Common elements.
     */
    public Set intersection(final Set array) {
        /*Set retain = new Set();
        int s = array.size();
        for (int j = 0; j < this.size(); j++) {
            for (int i = 0; i < array.size(); i++) {
                if (array.list[i] == this.list[j]) {
                    retain.add(this.list[j]);
                }
            }
        } return retain;*/
        return this.retainAll(array.list);

    }
    /**
     * Cartesian Product.
     *
     * @param      test  The test
     *
     * @return     cartesian Product.
     */
    public int[][] cartesianProduct(final Set test) {
        int limit = this.size() * test.size();
        int[][] result = new int[limit][2];
        if (this.size == 0 || test.size() == 0) {
            return null;
        } else {
            int m = 0;
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < test.size; j++) {
                    if (m < limit) {
                        result[m][0] = this.list[i];
                        result[m][1] = test.list[j];
                        m += 1;
                    }
                }
            }

        }
        return result;
    }


}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }


    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
            default:
                break;
            }
        }
    }
}
