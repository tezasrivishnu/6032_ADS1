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
		for (int i = 0; i < array.length - 2; i++) {
			long a = array[i];
			int start = i + 1;
			int end = array.length - 1;
			while (start < end) {
				long b = array[start];
				long c = array[end];
				if(a+b+c == 0) {
					count += 1;
					start += 1;
					end -= 1;
				} else if (a + b + c > 0) {
					end -= 1;
				} else {
					start += 1;
				}
			}
		}
		return count;
	}
}