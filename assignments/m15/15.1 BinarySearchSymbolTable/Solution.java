import java.util.Scanner;
import java.util.Arrays;
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * main method for the program.
	 * complexity O(n) as we are taking input n times.
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		BSTable bst = new BSTable();
		String[] tokens = scan.nextLine().split(" ");
		for (int i = 0; i < tokens.length; i++) {
			bst.put(tokens[i], i);
		}
		while (scan.hasNext()) {
			String[] items = scan.nextLine().split(" ");
			switch (items[0]) {
			case "max":
				System.out.println(bst.max());
				break;
			case "floor":
				System.out.println(bst.floor(items[1]));
				break;
			case "rank":
				System.out.println(bst.rank(items[1]));
				break;
			case "deleteMin":
				bst.deleteMin();
				break;
			case "contains":
				System.out.println(bst.contains(items[1]));
				break;
			case "keys":
				System.out.println(bst.keys());
				break;
			case "get":
				System.out.println(bst.get(items[1]));
				break;
			default:
				break;
			}
		}
	}
}
class BSTable {
	private String[] keyarr;
	private String[] valarr;
	private int size = 0;
	BSTable() {
		keyarr = new String[2];
		valarr = new String[2];
		size = 0;
	}
	public void put(String key, int value) {
		if (String.valueOf(value) == null) {
			delete(key);
			return;
		}
		int i = rank(key);
		if (i < size && keyarr[i].compareTo(key) == 0) {
			valarr[i] = String.valueOf(value);
			return;
		}
		if (size == keyarr.length) {
			resize(2 * keyarr.length);
		}
		for (int j = size; j > i; j--)  {
			keyarr[j] = keyarr[j - 1];
			valarr[j] = valarr[j - 1];
		}
		keyarr[i] = key;
		valarr[i] = String.valueOf(value);
		size++;
	}
	public String floor(String key) {
		int i = rank(key);
		if (i < size && key.compareTo(keyarr[i]) == 0) return keyarr[i];
		if (i == 0) return null;
		else return keyarr[i - 1];
	}
	public int rank(String key) {
		int low = 0;
		int high = size - 1;
		while (low <= high) {
			int midvalue = low + (high - low) / 2;
			int compare = key.compareTo(keyarr[midvalue]);
			if (compare < 0) {
				high = midvalue - 1;
			} else if (compare > 0) {
				low = midvalue + 1;
			} else {
				return midvalue;
			}
		}
		return low;
	}
	public void deleteMin() {
		delete(keyarr[0]);
	}
	public void delete(String key) {
		int i = rank(key);
		if (i == size || keyarr[i].compareTo(key) != 0) {
			return;
		}
		for (int j = i; j < size - 1; j++)  {
			keyarr[j] = keyarr[j + 1];
			valarr[j] = valarr[j + 1];
		}
		size--;
		keyarr[size] = null;
		valarr[size] = null;
		if (size > 0 && size == keyarr.length / 4) {
			resize(keyarr.length / 2);
		}
	}
	public boolean contains(String key) {
		return get(key) != null;
	}
	public String get(String key) {
		int i = rank(key);
		if (i < size && keyarr[i].compareTo(key) == 0) {
			return valarr[i];
		}
		return null;
	}
	public void resize(int capacity) {
		keyarr = Arrays.copyOf(keyarr, capacity);
		valarr = Arrays.copyOf(valarr, capacity);
	}
	public String keys() {
		String str = "";
		int i = 0;
		for (i = 0; i < size - 1; i++) {
			str += keyarr[i] + " " + valarr[i];
			str += "\n";
		}
		str += keyarr[i] + " " + valarr[i];
		return str;
	}
	public String max() {
        return keyarr[size-1];
    }
}