import java.util.Arrays;
import java.util.Scanner;
class CharacterStack {
	private char[] character;
	private int size;
	public CharacterStack() {
		character = new char[20];
		size = 0;
	}
	public int size() {
		return size;
	}
	char pop() {
		char result = character[--size];
		return result;
	}
	public void push(char c) {
		if (size == character.length) {
			character = Arrays.copyOf(character, size + 1);
		}
		character[size++] = c;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Solution sol = new Solution();
		String input = scan.next();
		sol.yesNo(input);
	}
	public void yesNo(String value) {
		CharacterStack stack = new CharacterStack();
		char[] string = value.toCharArray();
		int flag = 0;
		if (string[0] == '}' || string[0] == ']' || string[0] == ')') {
			System.out.println("No");
		} else {
			if (string[string.length - 1] == '{' || string[string.length - 1] == '[' || string[string.length - 1] == '(') {
				System.out.println("No");
			} else {
				for (Character c : string) {
					if (string[c] == '[' || string[c] == '{' || string[c] == '(') {
						stack.push(c);
					} else {
						char s = stack.pop();
						if (string[c] == '(' && s == ')') {
							flag = 1;
							break;
						} else if (string[c] == '[' && s == ']') {
							flag = 1;
							break;
						} else if (string[c] == '{' && s == '}') {
							flag = 1;
							break;
						} else {
							flag = 0;
							break;
						}
					}
				}
				if (flag == 1) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}

	}
}