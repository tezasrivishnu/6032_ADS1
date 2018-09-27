import java.util.Arrays;
import java.util.Scanner;
class CharacterStack {
	private char[] character;
	private int count;
	public CharacterStack(int size) {
		character = new char[size];
		count = -1;
	}
	public int size() {
		return count;
	}
	public char pop() {
		if (count > 0) {
			char result = character[count--];
			return result;
		}
		return ' ';
	}
	public void push(char c) {
		character[count++] = c;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		Solution sol = new Solution();
		for (int i = 0; i < num; i++) {
			String input = scan.next();
			sol.yesNo(input);
		}
		// String input = scan.next();
		// sol.yesNo(input);
	}
	public void yesNo(String value) {
		CharacterStack stack = new CharacterStack(value.length());
		char[] string = value.toCharArray();
		int flag = 0;
		if (string[0] == '}' || string[0] == ']' || string[0] == ')') {
			System.out.println("NO");
		} else {
			if (string[string.length - 1] == '{' || string[string.length - 1] == '[' || string[string.length - 1] == '(') {
				System.out.println("NO");
			} else {
				for (int c = 0; c < string.length; c++) {
					if (string[c] == '[' || string[c] == '{' || string[c] == '(') {
						stack.push(string[c]);
					} else {
						char s = stack.pop();
						if (s == ' ') {
							flag = 1;
							break;
						} else {
							if (string[c] == '(' && s == ')') {
								continue;
							} else if (string[c] == '[' && s == ']') {
								continue;
							} else if (string[c] == '{' && s == '}') {
								continue;
							} else {
								flag = 1;
								break;
							}
						}

					}
				}
				if (flag == 0 && stack.size() == 0) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}

	}
}