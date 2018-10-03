import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * main method for the progra.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Merge merge = new Merge();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            merge.sort(tokens);
            System.out.println(merge.toString(tokens));
            System.out.println();
        }
    }
}
/**
 * Class for merge.
 */
class Merge {
    /**
     * initializing value of 7.
     */
    private static final int SEVEN = 7;
    Insertion insertion = new Insertion();
    /**
     * Constructs the object.
     */
    Merge() {

    }
    /**
     * copying the array to auxxilary array.
     *
     * @param      a     array
     */
    public void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    /**
     * merging two arrays
     *
     * @param      a     array
     * @param      aux   The auxiliary array
     * @param      lo    The lower value
     * @param      mid   The middle value
     * @param      hi    The higher value
     */
    public void merge(final Comparable[] a, final Comparable[] aux,
        final int lo, final int mid, final int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = a[j++];
            } else if (j > hi) {
                aux[k] = a[i++];
            } else if (insertion.less(a[j], a[i])) {
                aux[k] = a[j++];
            } else {
                aux[k] = a[i++];
            }
        }
        assert isSorted(aux, lo, hi);
    }
    /**
     * sorting of two arrays
     *
     * @param      a     array
     * @param      aux   The auxiliary array
     * @param      lo    The lower array
     * @param      hi    The higher array
     */
    private void sort(final Comparable[] a, final Comparable[] aux,
        final int lo, final int hi) {
        //int cutoff = SEVEN;
        if (hi <= lo + SEVEN) {
            insertion.sorting(aux, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, a, lo, mid);
        sort(aux, a, mid + 1, hi);
        if (!insertion.less(a[mid + 1], a[mid])) {
            for (int i = lo; i <= hi; i++) {
                aux[i] = a[i];
            }
            System.out.println(
    "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(a, aux, lo, mid, hi);
    }
    /**
     * Returns a string representation of the object.
     *
     * @param      input  array
     *
     * @return     String representation of the object.
     */
    public String toString(final Comparable[] input) {
        String str = "[";
        int i;
        for (i = 0; i < input.length - 1; i++) {
            str += input[i] + ", ";
        }
        str += input[i] + "]";
        return str;
    }
    /**
     * Method to determine if the array is sorted (or) not.
     * 
     * @param      a     array
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**
     * Method to determine if the array is sorted (or) not.
     * @param      a     array
     * @param      lo    The lower value
     * @param      hi    The higher value
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a,
                            final int lo, final int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (insertion.less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
/**
 * Class for insertion.
 */
class Insertion {
    /**
     * method for insertion sort.
     *
     * @param      a     array
     * @param      lo    The lower value
     * @param      hi    The higher value
     */
    public void sorting(final Comparable[] a,
        final int lo, final int hi) {
        // int[] teams = team;
        // for (int i = lo; i < hi; i++) {
        //  int key = teams[i];
        //  int j = i - 1;
        //  while (j >= 0 && less(key, teams[j])) {
        //      teams[j + 1] = teams[j];
        //      j = j - 1;

        //  }
        //  teams[j + 1] = key;
        // }
        // return teams;
        // for (int i = lo; i <= hi; i++)
        // Comparable[] sort = team;
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     * swapping of two elements
     *
     * @param      a     array
     * @param      i     index
     * @param      j     index
     */
    private void exch(final Comparable[] a,
        final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * comparing two elements.
     *
     * @param      one   value
     * @param      two   value
     *
     * @return     true or false
     */
    public boolean less(final Comparable one, final Comparable two) {
        return one.compareTo(two) < 0;
    }
}