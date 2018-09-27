import java.util.Arrays;
import java.util.Scanner;
class CharacterStack {
	private char[] character;
	private int size;
	public CharacterStack() {
		character = new char[20];
		size = -1;
	}
	public int size() {
		return size;
	}
	public char pop() {
		if (size >= 0) {
			char result = character[size--];
			return result;
		}
		return ' ';
	}
	public void push(char c) {
		if (size == character.length-1) {
			character = Arrays.copyOf(character, size + 1);
		}
		character[++size] = c;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CharacterStack stack = new CharacterStack();
		int num = scan.nextInt();
		Solution sol = new Solution();
		for (int i = 0; i < num; i++) {
			String input = scan.next();
			sol.yesNo(input, stack);
		}
		// String input = scan.next();
		// sol.yesNo(input);
	}
	public void yesNo(String value, CharacterStack stack) {
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
						if(s == ' '){
							flag = 1;
							break;
						}
						if (string[c] == '(' && s == ')') {
							continue;
						} else if (string[c] == '[' && s == ']') {
							continue;
						} else if (string[c] == '{' && s == '}') {
							continue;
						} else {
							flag = 0;
							break;
						}
					}
				}
				if (flag == 0 && stack.size() == -1) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}

	}
}