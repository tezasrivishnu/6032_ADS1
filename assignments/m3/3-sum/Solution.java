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
		for (int i = 0; i < array.length - 1; i++) {
			long k = -(array[i] + array[i + 1]);
			for (int j = 0; j < array.length; j++) {
				if (k + array[j] == 0) {
					count += 1;
				}
			}
		}
		return count;
	}
}

