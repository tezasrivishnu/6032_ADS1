import java.util.Scanner;
import java.util.Arrays;
class Solution {
    public static void main(final String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int firstSize = sc.nextInt();
        int secondSize = sc.nextInt();
        String[] firstarr = sc.next().split(",");
        String[] secondarr = sc.next().split(",");
        int[] firstarray = new int[firstSize];
        int[] secondarray = new int[secondSize];
        for (int i = 0; i < firstSize; i++) {
            firstarray[i] = Integer.parseInt(firstarr[i]);
        }
        for (int i = 0; i < secondSize; i++) {
            secondarray[i] = Integer.parseInt(secondarr[i]);
        }
        if (firstSize == 0) {
            sol.toString(secondarray);
        }
        if (secondSize == 0) {
            sol.toString(firstarray);
        } else {
            int[] sorted = sol.sortedArray(firstSize, secondSize, firstarray, secondarray);
            System.out.println(sol.toString(sorted));
        }
    }
    public int[] sortedArray(final int onesize, final int twosize,
                             final int[] onearray, final int[] twoarray) {
        // int[] firstarray = new int[onesize];
        // int[] secondarray = new int[twosize];
        // for (int i = 0; i < onesize; i++) {
        //     firstarray[i] = Integer.parseInt(onearray[i]);
        // }
        // for (int i = 0; i < twosize; i++) {
        //     secondarray[i] = Integer.parseInt(twoarray[i]);
        // }
        int[] sortedArray = new int[onesize + twosize];
        int index = 0;
        int firstindex = 0;
        int secondindex = 0;
        if (onearray.length == 0) {
            sortedArray = twoarray;
        }
        if (twoarray.length == 0) {
            sortedArray = onearray;
        } else {
            while (firstindex < onesize && secondindex < twosize) {
                if (onearray[firstindex] < twoarray[secondindex]) {
                    sortedArray[index] = onearray[firstindex];
                    firstindex++;
                } else {
                    sortedArray[index] = twoarray[secondindex];
                    secondindex++;
                }
                index += 1;
            }
            while (firstindex < onesize) {
                sortedArray[index] = onearray[firstindex];
                firstindex += 1;
                index += 1;
            }
            while (secondindex < twosize) {
                sortedArray[index] = twoarray[secondindex];
                secondindex += 1;
                index += 1;
            }
        }
        //System.out.println(Arrays.toString(sortedArray));
        return sortedArray;
    }
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

