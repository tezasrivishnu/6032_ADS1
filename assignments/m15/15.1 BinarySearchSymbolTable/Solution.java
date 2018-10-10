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
/**
 * Class for binary system table.
 */
class BSTable {
    /**
     * declaring key elements array.
     */
    private String[] keyarr;
    /**
     * declaring value elements array.
     */
    private String[] valarr;
    /**
     * declaring int size.
     */
    private int size = 0;
    /**
     * Constructs the object.
     */
    BSTable() {
        keyarr = new String[2];
        valarr = new String[2];
        size = 0;
    }
    /**
     * adding key value pair to respective arrays.
     * complexity O(logn) we are adding a element,
     * if element is present we are updating the element value.
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final String key, final int value) {
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
    /**
     * returns the element value. if not present
     * returns previous element value.
     * complexity O()
     * @param      key   The key
     *
     * @return     the key if present else the
     * previous element of the index.
     */
    public String floor(final String key) {
        int i = rank(key);
        if (i < size && key.compareTo(keyarr[i]) == 0) {
            return keyarr[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keyarr[i - 1];
        }
    }
    /**
     * the index value of the key.
     *  complexity O(logn) as we are using binary search.
     * @param      key   The key
     *
     * @return     index int.
     */
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
    /**
     * deleting the minimum element.
     * complexity O(1) as we are removing the min element.
     */
    public void deleteMin() {
        delete(keyarr[0]);
    }
    /**
     * deleting the key value pair.
     *  complexity O(n) we are moving all
     *  the elements to the left.
     * @param      key   The key
     */
    public void delete(final String key) {
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
    /**
     * if a element is present or not.
     * complexity O(1) as we are checking for a element.
     * @param      key   The key
     *
     * @return     true if present or false.
     */
    public boolean contains(final String key) {
        return get(key) != null;
    }
    /**
     * getting a element.
     * complexity O(1) we are returning  the value of the key.
     * @param      key   The key
     *
     * @return     value of the key.
     */
    public String get(final String key) {
        int i = rank(key);
        if (i < size && keyarr[i].compareTo(key) == 0) {
            return valarr[i];
        }
        return null;
    }
    /**
     * resizing the arrays.
     * complexity O(1)
     * @param      capacity  The capacity
     */
    public void resize(final int capacity) {
        keyarr = Arrays.copyOf(keyarr, capacity);
        valarr = Arrays.copyOf(valarr, capacity);
    }
    /**
     * the string representation of the key value pairs.
     * complexity O(n) we are iterating over the full size.
     * @return     string representation.
     */
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
    /**
     * returning the maximun element.
     * complexity O(1) as we are just returning a value.
     * @return     maxx. element
     */
    public String max() {
        return keyarr[size - 1];
    }
}
