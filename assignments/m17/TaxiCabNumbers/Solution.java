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
     * declaring the value of 600. 
     */
    private static final int SIXHUNDRED = 600;
    /**
     * main method for the program.
     * complexity O(n) as we are taking the input n times.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int nthnumber = scan.nextInt();
        int mpairs = scan.nextInt();
        int mcounter = 0;
        int ncounter = 0;
        MinPQ<TaxiCab> pq = new MinPQ<TaxiCab>();
        for (int i = 0; i <= SIXHUNDRED; i++) {
            pq.insert(new TaxiCab(i, i));
        }
        int tempsum = -1;
        while (!pq.isEmpty()) {
            TaxiCab s = pq.delMin();
            if (tempsum == s.getSum()) {
                mcounter++;
            } else {
                mcounter = 0;
            }
            if (mcounter == mpairs - 1) {
                nthnumber--;
                if (nthnumber == 0) {
                    System.out.println(s.getSum());
                    break;
                }
            }
            tempsum = s.getSum();
            if (s.getSecond() < SIXHUNDRED) {
                pq.insert(new TaxiCab(s.getFirst(), s.getSecond() + 1));
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
    private int sum;
    /**
     * initializing the i variable.
     */
    private int i;
    /**
     * initializing the j variable.
     */
    private int j;
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
    /**
     * Gets the first number.
     * complexity O(1)
     * @return     The first.
     */
    public int getFirst() {
        return this.i;
    }
    /**
     * Gets the second number.
     * complexity O(1)
     * @return     The second.
     */
    public int getSecond() {
        return this.j;
    }
    /**
     * Gets the sum of cubes of two numbers.
     * complexity O(1)
     * @return     The sum.
     */
    public int getSum() {
        return this.sum;
    }
}
