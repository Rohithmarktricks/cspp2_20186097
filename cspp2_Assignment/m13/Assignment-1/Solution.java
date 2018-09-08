import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
//import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * Class for set.
 * @author :
 */
class Set {
    private int[] list;
    private int size;
    private final int lIMIT = 100;

    public Set() {
        list = new int[lIMIT];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(int item) {
        list[size] = item;
        size++;
    }

    public void add(int[] items) {
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


public boolean contains(int item) {
    for (int element : list) {
        if (item == element) {
            return true;
        }
    } return false;
}

public Set retainAll(int[] array) {
    Set retain = new Set();
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j<this.size(); j++) {
            if (array[i] == this.list[j]){
                retain.add(array[i]);
            }
        }
    } return retain;
}

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

public Set intersection(Set array) {
    Set retain = new Set();
    int s = array.size();
    for (int i = 0; i < array.size(); i++) {
        for (int j = 0; j<this.size(); j++) {
            if (array.list[i] == this.list[j]){
                retain.add(array.list[i]);
            }
        }
    } return retain;
    
}

/*public int[][] cartesianProduct(Set test){
    int[][] newarray = new int[20][20];
    if (this.size() == 0 || test.size() == 0){
        return null;
    } else {
        for(int j = 0; j < this.size(); j++){
        for (int i = 0; i < test.size(); i++){
            newarray[j][i] = test[i];
        }
    }
    } return newarray;

}
*/

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
            /*case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;*/
            default:
                break;
            }
        }
    }
}
