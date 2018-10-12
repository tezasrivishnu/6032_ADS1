import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method for the program.
     * complexity O(n) as we are taking the input n times.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int nthnumber = scan.nextInt();
        int mpairs = scan.nextInt();
        int mcounter = 1;
        int ncounter = 0;
        MinPQ<TaxiCab> pq = new MinPQ<TaxiCab>();
        for (int i = 0; i <= 400; i++) {
            pq.insert(new TaxiCab(i, i));
        }
        int tempsum = 0;
        while (pq.isEmpty()) {
            TaxiCab s = pq.delMin();
            if (tempsum == s.sum) {
                mcounter++;
            } else {
                mcounter = 0;
            }
            if (mcounter == mpairs) {
                ncounter++;
                if (ncounter == nthnumber) {
                    System.out.println(s.sum);
                    break;
                }
            }
            tempsum = s.sum;
            if (s.j < 400) {
                pq.insert(new TaxiCab(s.i, s.j + 1));
            }
        }
    }
}
/**
 * Class for taxi cab.
 */
class TaxiCab implements Comparable<TaxiCab> {
    /**
     * initializing the sum variable.
     */
    int sum;
    /**
     * initializing the i variable.
     */
    int i;
    /**
     * initializing the j variable.
     */
    int j;
    /**
     * Constructs the object.
     *
     * @param      one     number
     * @param      two     number
     */
    TaxiCab(final int one, final int two) {
        this.sum = one * one * one + two * two * two;
        this.i = one;
        this.j = two;
    }
    /**
     * comparing the two objects of taxicab class.
     * complexity O(1) as we are comparing only two objects.
     * @param      that  The that
     *
     * @return     int value
     */
    public int compareTo(final TaxiCab that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }
        return 0;
    }
}
