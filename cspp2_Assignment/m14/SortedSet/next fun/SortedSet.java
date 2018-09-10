import java.util.Arrays;
class Sorted extends Set {

	public Sorted(){
		super();
	}

	

	public int[] subSet(int x, int y) {
		if (x > y) {
			System.out.println("Invalid Arguments to Subset Exception");
		}
		int i = 0;
		int j = 0;
		for (; i < size(); i++) {
			if (this.set[i] >= x ) {
				break;
			}
		}
		for (j = i; j < size(); j++) {
			if (this.set[j] >= y) {
				break;
			}
		}
		int[] result = new int[j - i];
        for (int k = 0;i < j;i++,k++) {
            result[k] = this.set[k];
        }
		return result; 
	}

	public int[] headSet(int toElement) {
		int[] newSet = new int[this.size()];
		for (int j = 0; j < this.size; j++) {
			if (this.set[j] < toElement) {
				newSet.add(this.set[j]);
			}
		}
		return newSet;
	}

	public int last() {
		int max = 0;
		if (this.size == 0) {
			System.out.println("Set​ ​ Empty​ ​ Exception");
		} else {
			for (int j = 0; j < this.size; j++) {
				if (this.set[j] > max) {
					max = this.set[j];
				}
			}
		} return max;
	}

	public void addAll(int[] realArr) {
		Arrays.sort(realArr);
		int[] sorted = new int[realArr.length];
		for (int i = 0; i < realArr.length ; i++) {
			sorted[i] = realArr[i];
		}

	}

}

public class SortedSet {
	public static void main(String[] args) {
		Sorted newsort = new Sorted();
		newsort.add(-1);
		newsort.add(2);
		newsort.add(5);
		newsort.add(3);
		System.out.println(newsort.last());
		System.out.println(newsort.headSet(4));
		/*Scanner stdin = new Scanner(new BufferedInputStream(System.in));
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
			case "subSet":
				s = new Set();
				intArray = intArray(tokens[1]);
		    default:
		        break;
		    }
		}*/
	}
}