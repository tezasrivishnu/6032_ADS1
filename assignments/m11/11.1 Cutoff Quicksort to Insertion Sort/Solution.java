import java.util.Scanner;
/**
 * class Solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not using.
    }
    /**
     * main method for the program.
     * complexity O(N) as we are taking input.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (scan.hasNext()) {
            int number = Integer.parseInt(scan.nextLine());
            QuickSort sort = new QuickSort(number);
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[0].length() == 0) {
                System.out.println("[]");
            } else {
                sort.sort(tokens);
                System.out.println(sort.toString(tokens));
            }
        }
    }
}

/**
 * Class for quick sort.
 */
class QuickSort {
    /**
     * initializing the variable int cutoff.
     */
    private int cutoff;
    /**
     * insertion class object.
     */
    private Insertion insertion;
    /**
    * Constructs the object.
     * complexity O(n) as we are assigning a value.
     * @param  number the cutoff value.
    */
    QuickSort(final int number) {
        cutoff = number;
        insertion = new Insertion();

    }
    /**
     * method to send to sorting method.
     * complexity O(1) as we are calling a method once.
     * @param      array   array
     */
    public void sort(final Comparable[] array) {
        sort(array, 0, array.length - 1);
    }
    /**
     * sorting of the array.
     *
     * @param      array   The array
     * @param      low     The low value
     * @param      high    The high value
     */
    public void sort(final Comparable[] array, final int low,
                     final int high) {
        int n = high - low + 1;
        if (n <= cutoff) {
            insertion.sorting(array, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int j = partition(array, low, high);
        sort(array, low, j - 1);
        sort(array, j + 1, high);
    }
    /**
     * partitioning the array and swapping the elements.
     *
     * @param      array  The array
     * @param      low    The low value
     * @param      high   The high value
     *
     * @return     the parition index.
     */
    public static int partition(final Comparable[] array,
                                final int low,
                                final int high) {
        int i = low;
        int j = high + 1;
        Comparable v = array[low];
        while (true) {
            while (less(array[++i], v)) {
                if (i == high) {
                    break;
                }
            }
            while (less(v, array[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(array, i, j);
        }
        exch(array, low, j);
        System.out.println(toString(array));

        return j;
    }
    /**
     * comparing two elements.
     * complexity O(1) as we are checking once.
     * @param      one   value
     * @param      two   value
     *
     * @return     true or false
     */
    public static boolean less(final Comparable one,
                               final Comparable two) {
        return one.compareTo(two) < 0;
    }
    /**
     * swapping of two elements.
     * complexity is O(1) as we are just swapping the elements.
     * @param      array     array
     * @param      i     index
     * @param      j     index
     */
    public static void exch(final Comparable[] array,
                            final int i, final int j) {
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
    /**
     * Returns a string representation of the object.
     * complexity O(n) as we are iterating the whole array
     * to print.
     * @param      array  The array
     *
     * @return     String representation of the object.
     */
    public static String toString(final Comparable[] array) {
        String str = "[";
        int i;
        for (i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        str += array[i] + "]";
        return str;
    }
}
/**
 * Class for insertion.
 */
class Insertion {
    /**
     * method for insertion sort.
     * complecity is O(n^2/2) as it is insertion sort.
     * @param      a     array
     * @param      lo    The lower value
     * @param      hi    The higher value
     */
    public void sorting(final Comparable[] a,
                        final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && lesser(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }
    /**
     * swapping of two elements.
     * complexity is O(1) as we are just swapping the elements.
     * @param      a     array
     * @param      i     index
     * @param      j     index
     */
    private void exchange(final Comparable[] a,
                          final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * comparing two elements.
     * complexity O(1) as we are checking once.
     * @param      one   value
     * @param      two   value
     *
     * @return     true or false
     */
    public boolean lesser(final Comparable one, final Comparable two) {
        return one.compareTo(two) < 0;
    }
}
