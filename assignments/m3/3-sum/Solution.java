import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 * @author tezasrivishnu
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main program for the class solution.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        ThreeSum sum = new ThreeSum();
        int input = sc.nextInt();
        long[] inputarray = new long[input];
        for (int i = 0; i < input; i++) {
            inputarray[i] = sc.nextLong();
        }
        System.out.println(sum.threeSum(inputarray));
    }
}
class ThreeSum {
    /**
     * Constructs the object.
     */
    ThreeSum() {

    }
    /**
     * finding if sum of three elements is zero using 3-sum complexity.
     *
     * @param      array  the input array.
     *
     * @return     the count of the pairs whose sum is zero.
     */
    public int threeSum(final long[] array) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length - 2; i++) {
            long a = array[i];
            int j = i + 1;
            int k = array.length - 1;
            while (j < k) {
                long b = array[j];
                long c = array[k];
                if (a + b + c == 0) {
                    count += 1;
                    j += 1;
                    k -= 1;
                } else if (a + b + c > 0) {
                    k -= 1;
                } else {
                    j += 1;
                }
            }
        }
        return count;
    }
}
