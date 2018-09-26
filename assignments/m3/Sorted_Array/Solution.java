import java.util.Scanner;
import java.util.Arrays;
class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int firstSize = sc.nextInt();
        int secondSize = sc.nextInt();
        String[] firstarr = sc.next().split(",");
        String[] secondarr = sc.next().split(",");
        int[] sorted = sol.sortedArray(firstSize, secondSize, firstarr, secondarr);
        System.out.println(sol.toString(sorted));
    }
    public int[] sortedArray(int onesize, int twosize, String[] onearray, String[] twoarray) {
        int[] firstarray = new int[onesize];
        int[] secondarray = new int[twosize];
        for (int i = 0; i < onesize; i++) {
            firstarray[i] = Integer.parseInt(onearray[i]);
        }
        for (int i = 0; i < twosize; i++) {
            secondarray[i] = Integer.parseInt(twoarray[i]);
        }
        int[] sortedArray = new int[onesize + twosize];
        int index = 0;
        int firstindex = 0;
        int secondindex = 0;
        while(firstindex < onesize && secondindex < twosize){
            if (firstarray[firstindex] < secondarray[secondindex]) {
                sortedArray[index] = firstarray[firstindex];
                firstindex++;
            } else {
                sortedArray[index] = secondarray[secondindex];
                secondindex++;
            }
            index += 1;
        }
        while(firstindex < onesize) {
            sortedArray[index] = firstarray[firstindex];
            firstindex += 1;
            index += 1;
        }
        while(secondindex < twosize) {
            sortedArray[index] = secondarray[secondindex];
            secondindex += 1;
            index += 1;
        }
        //System.out.println(Arrays.toString(sortedArray));
        return sortedArray;
    }
    public String toString(int[] array) {
        String s = "";
        int i = 0;
        for (i = 0; i<array.length-1; i++) {
            s += array[i]+",";
        }
        s += array[i];
        return s;
    }
}

