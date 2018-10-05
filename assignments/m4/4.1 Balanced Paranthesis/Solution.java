import java.util.Scanner;
/**
 * List of characters class.
 * @author tezasrivishnu
 */
class CharacterStack {
    /**
     * declaring the chararcter array.
     */
    private char[] character;
    /**
     * declaring the int count variable.
     */
    private int count;
    /**
     * Constructs the object.
     *
     * @param      size  The size
     */
    CharacterStack(final int size) {
        character = new char[size];
        count = 0;
    }
    /**
     * return the size of the array.
     *
     * @return     the size count.
     */
    public int size() {
        return count;
    }
    /**
     * getting the last element in array.
     *
     * @return     char element.
     */
    public char pop() {
        if (count > 0) {
            char result = character[count--];
            return result;
        }
        return ' ';
    }
    /**
     * adding a element to array.
     *
     * @param      c     the input character.
     */
    public void push(final char c) {
        character[count++] = c;
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main class for the solution class.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        BalancedParanthesis paranthesis = new BalancedParanthesis();
        for (int i = 0; i < num; i++) {
            String input = scan.next();
            paranthesis.yesNo(input);
        }
    }
}
/**
 * Class for balanced paranthesis.
 */
class BalancedParanthesis {
    /**
     * Constructs the object.
     */
    BalancedParanthesis() {

    }
    /**
     * checking the parathesis are in order or not.
     *
     * @param      value  The value
     */
    public void yesNo(final String value) {
        CharacterStack stack = new CharacterStack(value.length());
        char[] string = value.toCharArray();
        int flag = 0;
        if (string[0] == '}' || string[0] == ']' || string[0] == ')') {
            System.out.println("NO");
        } else {
            if (string[string.length - 1] == '{'
                    || string[string.length - 1] == '['
                    || string[string.length - 1] == '(') {
                System.out.println("NO");
            } else {
                for (int c = 0; c < string.length; c++) {
                    if (string[c] == '[' || string[c] == '{'
                            || string[c] == '(') {
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
