import java.util.Scanner;
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
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length - 1; j++) {
				int k = i + j;
				if (array[i] + array[j] + array[k-1] == 0) {
					count += 1;
				}
			}
		}
		return count;
	}
}