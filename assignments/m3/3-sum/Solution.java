import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution sol = new Solution();
		int input = sc.nextInt();
		int[] inputarray = new int[input];
		for (int i = 0; i<input; i++) {
			inputarray[i] = sc.nextInt();
		}
		System.out.println(sol.threeSum(inputarray));
	}
	public int threeSum(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length-1; j++) {
				for (int k = j; k < array.length-2; k++) {
					if((array[i] + array[j] + array[k]) == 0) {
						count += 1;
					}
				}
			}
		}
		return count;
	}
}