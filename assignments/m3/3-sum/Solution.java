import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution sol = new Solution();
		int input = sc.nextInt();
		long[] inputarray = new long[input];
		for (int i = 0; i < input; i++) {
			inputarray[i] = sc.nextLong();
		}
		System.out.println(sol.threeSum(inputarray));
	}
	public int threeSum(long[] array) {
		Arrays.sort(array);
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			int j = i + 1;
			int k = array.length - 1;
			while (j < k) {
				if (array[i] + array [j] + array[j] == 0) {
					count += 1;
				}
				j++;
			}
		}
		return count;
	}
}