import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinearProbing lp = new LinearProbing();
		String number = scan.nextLine();
		while(scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
			case "put":
				lp.put(tokens[1], Integer.parseInt(tokens[2]));
				break;
			case "get":
				System.out.println(lp.get(tokens[1]));
				break;
			case "delete":
				lp.delete(tokens[1]);
				break;
			case "display":
				System.out.println(lp.display());
				break;
			default:
				break;
			}
		}
	}
}
class LinearProbing {
	static final int capacity = 4;
	String[] character;
	Integer[] value;
	int arraylength;
	int size;
	public LinearProbing() {
		this(capacity);
	}
	LinearProbing(int capacity) {
		arraylength = capacity;
		size = 0;
		character = new String[arraylength];
		value = new Integer[arraylength];
	}

	public void put(String string, int val) {
		if (size >= (arraylength / 2)) {
			resize(2 * arraylength);
		}
		int index;
		for (index = hash(string); character[index] != null;
		        index = (index + 1) % arraylength) {
			if (character[index].equals(string)) {
				value[index] = val;
				return;
			}
		}
		character[index] = string;
		value[index] = val;
		size++;
	}
	public int hash(String string) {
		return ((11 * string.hashCode()) % arraylength);
	}
	public void resize(int capacity) {
		LinearProbing temp = new LinearProbing(capacity);
		for (int i = 0; i < arraylength; i++) {
			if (character[i] != null) {
				temp.put(character[i], value[i]);
			}
		}
		character = temp.character;
		value = temp.value;
		arraylength = temp.arraylength;
		// character = Arrays.copyOf(character, capacity);
		// value = Arrays.copyOf(value, capacity);
	}
	public Integer get(String string) {
		// System.out.println(Arrays.toString(character));
		int index;
		for (index = hash(string); character[index] != null;
		        index = (index + 1) % arraylength) {
			// System.out.println(character[index]);
			if (character[index].equals(string)) {
				//		System.out.println(value[index]);
				return value[index];
			}
		}
		return null;
	}
	public Iterable<String> keys() {
		Queue<String> queue = new Queue<String>();
		for (int i = 0; i < arraylength; i++)
			if (character[i] != null) {
				queue.enqueue(character[i]);
			}
		return queue;
	}
	public String display() {
		if (size == 0) {
			return "{}";
		}
		String str = "{";
		for (String check : keys()) {
			str += check + ":" + get(check) + ", ";
		}
		str = str.substring(0, str.length() - 2);
		str += "}";
		return str;
	}
	public void delete(String string) {
		if (!contains(string)) {
			return;
		}
		int i = hash(string);
		while (!string.equals(character[i])) {
			i = (i + 1) % arraylength;
		}
		character[i] = null;
		value[i] = null;
		i = (i + 1) % arraylength;
		while (character[i] != null) {
			String charac = character[i];
			int val = value[i];
			character[i] = null;
			value[i] = null;
			size--;
			put(charac, val);
			i = (i + 1) % arraylength;
		}
		size--;
		if (size > 0 && size <= arraylength / 8) {
			resize(arraylength / 2);
		}
	}
	public boolean contains(String string) {
		return get(string) != null;
	}
}

