import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 * @author tezasrivishnu.
 */
class Solution {
    /**
     * main program for solution class.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        // int firstSize = sc.nextInt();
        // int secondSize = sc.nextInt();
        String[] firstarr = new String[sc.nextInt()];
        String[] secondarr = new String[sc.nextInt()];
        // if (firstSize == 0) {
        //     int[] secondarray = new int[secondSize];
        //     for (int i = 0; i < secondSize; i++) {
        //         secondarray[i] = (secondarr[i]);
        //     }
        //     sol.toString(secondarray);
        // }
        // if (secondSize == 0) {
        //     int[] firstarray = new int[firstSize];
        //     for (int i = 0; i < firstSize; i++) {
        //         firstarray[i] = Integer.parseInt(firstarr[i]);
        //     }
        //     sol.toString(firstarray);
        // } else {
        if (firstarr.length == 0) {
            firstarr = sc.nextLine().split(",");
            secondarr = sc.nextLine().split(",");
        } else {
            firstarr = sc.nextLine().split(",");
            secondarr = sc.nextLine().split(",");
            int[] sorted = sol.sortedArray(firstarr, secondarr);
            System.out.println(sol.toString(sorted));
        }
    }

    /**
     * merging two sorted array into one sorted array.
     *
     * @param      onesize   The onesize
     * @param      twosize   The twosize
     * @param      onearray  The onearray
     * @param      twoarray  The twoarray
     *
     * @return     { description_of_the_return_value }
     */
    public int[] sortedArray(String[] onearray, final String[] twoarray) {
        System.out.println("here");
        int[] firstarray = new int[onearray.length];
        int[] secondarray = new int[twoarray.length];
        for (int i = 0; i < onearray.length; i++) {
            firstarray[i] = Integer.parseInt(onearray[i]);
        }
        for (int i = 0; i < twoarray.length; i++) {
            secondarray[i] = Integer.parseInt(twoarray[i]);
        }
        int[] sortedArray = new int[firstarray.length + secondarray.length];
        int index = 0;
        int firstindex = 0;
        int secondindex = 0;
        while (firstindex < firstarray.length && secondindex < secondarray.length) {
            if (firstarray[firstindex] < secondarray[secondindex]) {
                sortedArray[index] = firstarray[firstindex];
                firstindex++;
            } else {
                sortedArray[index] = secondarray[secondindex];
                secondindex++;
            }
            index += 1;
        }
        while (firstindex < onearray.length) {
            sortedArray[index] = firstarray[firstindex];
            firstindex += 1;
            index += 1;
        }
        while (secondindex < secondarray.length) {
            sortedArray[index] = secondarray[secondindex];
            secondindex += 1;
            index += 1;
        }

        System.out.println(Arrays.toString(sortedArray));
        return sortedArray;
    }
    /**
     * Returns a string representation of the sorted array
     *
     * @param      array  The array
     *
     * @return     String representation of the sorted array.
     */
    public String toString(final int[] array) {
        String s = "";
        int i = 0;
        for (i = 0; i < array.length - 1; i++) {
            s += array[i] + ",";
        }
        s += array[i];
        return s;
    }
}

