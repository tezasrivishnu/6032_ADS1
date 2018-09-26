import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {
    /**
     * main function for the solution class.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        String[] inparray = sc.next().split(",");
        sol.noOfPairs(inparray);
    }
    /**
     * counting the pair elements.
     *
     * @param      array  The array
     */
    public void noOfPairs(final String[] array) {
        int[] intarray = new int[array.length];
        for (int i = 0; i<array.length; i++) {
            intarray[i] = Integer.parseInt(array[i]);
        }
        Arrays.sort(intarray);
        int start = 0;
        int end = intarray[0];
        int count = 0;
        for (int i = 1; i<intarray.length; i++) {
            if(intarray[i] == end) {
                count += 1;
            }
            end = intarray[i];
        }
        System.out.println(count);
    }
}
