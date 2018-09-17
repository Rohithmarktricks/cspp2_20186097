import java.io.BufferedInputStream;
import java.util.Scanner;

public class GenericList<L> {
    L[] list;
    private int size;

    protected GenericList() {
        list = new L[10];
        size = 0;
    }

    public GenericList(int n) {
        list = new L[n];
        size = n;
    }

    public void add(L item) {
        list[size++] = item;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            return list[index];
        }
    }

    public String toString() {
        if (size == 0)
            return "";
        String str = "[";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }

    public boolean contains(L item) {
        return indexOf(item) == -1;
    }

    public int indexOf(L item) {
        for (int i = 0; i < size; i++) {
            if (item == list[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        // create an object of the list to invoke methods on it
        GenericList<Integer> lint = new GenericList<Integer>();
        GenericList<String> lstr = new GenericList<String>();

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
            case "add":
                lint.add(Integer.parseInt(tokens[1]));
                break;
            case "size":
                // invoke size method and print the list size
                // BTW, list size is not the array size
                // it is the number of items in the list
                System.out.println(lint.size());
                break;
            case "print":
                // print the list (implement toString for this to work)
                // expected format is [item-1,item-2,...,item-n]
                // review the output testcase file
                System.out.println(lint);
                break;
            case "remove":
                lint.remove(Integer.parseInt(tokens[1]));
                break;
            case "indexOf":
                System.out.println(lint.indexOf(Integer.parseInt(tokens[1])));
                break;
            case "get":
                System.out.println(lint.get(Integer.parseInt(tokens[1])));
                break;
            case "contains":
                System.out.println(lint.contains(Integer.parseInt(tokens[1])));
                break;
            }
        }
    }
}
