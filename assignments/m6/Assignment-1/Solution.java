import java.util.Scanner;
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**
     * initializing value of 10.
     */
    private static final int TEN = 10;
    /**
     * Constructs the object.
     */
    private AddLargeNumbers() {

    }
    /**
     * converts the string to linked list.
     *
     * @param      number  The number
     *
     * @return    linked list.
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList<Character> str = new LinkedList<Character>();
        String input = number;
        for (int i = 0; i < input.length(); i++) {
            str.push(input.charAt(i));
        }
        LinkedList<Character> str1 = new LinkedList<Character>();
        while (!str.isEmpty()) {
            str1.push(str.pop());
        }
        return str1;
    }
    /**
     * converts the linkedlist to string.
     *
     * @param      list  The list
     *
     * @return     string.
     */
    public static String digitsToNumber(final LinkedList list) {
        String string = "";
        // for (int i = 0; i < list.size(); i++) {
        //     string = string + list.pop();
        // }
        while (!(list.isEmpty())) {
            string = string + list.pop();
        }
        return string;
    }
    /**
     * adding to linked lists.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     a linked list.
     */
    public static LinkedList addLargeNumbers(final LinkedList list1,
            final LinkedList list2) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        LinkedList<Character> one1 = list1;
        LinkedList<Character> two1 = list2;
        LinkedList<Character> one = new LinkedList<Character>();
        LinkedList<Character> two = new LinkedList<Character>();
        while (!one1.isEmpty()) {
            one.push(one1.pop());
        }
        while (!two1.isEmpty()) {
            two.push(two1.pop());
        }
        int input = 0;
        int quo1 = 0;
        int result = 0;
        while (!one.isEmpty() && !two.isEmpty()) {
            char ch = one.pop();
            char ch1 = two.pop();
            input = quo1 + Integer.parseInt(String.valueOf(ch))
            + Integer.parseInt(String.valueOf(ch1));
            quo1 = 0;
            //System.out.println("input "+input);
            if (input >= TEN) {
                int reamin = input % TEN;
                int quo = input / TEN;
                quo1 = quo;
                result = reamin;
                res.push(result);
            } else {
                result = input;
                res.push(result);
            }
        }
        while (!one.isEmpty()) {
            char ch = one.pop();
            input = quo1 + Integer.parseInt(String.valueOf(ch));
            quo1 = 0;
            if (input >= TEN) {
                int reamin = input % TEN;
                int quo = input / TEN;
                quo1 = quo;
                result = reamin;
                res.push(result);
            } else {
                result = input;
                res.push(result);
            }
        }
        while (!two.isEmpty()) {
            char ch = two.pop();
            input = quo1 + Integer.parseInt(String.valueOf(ch));
            quo1 = 0;
            if (input >= TEN) {
                int reamin = input % TEN;
                int quo = input / TEN;
                quo1 = quo;
                result = reamin;
                res.push(result);
            } else {
                result = input;
                res.push(result);
            }
        }
        if (quo1 > 0) {
            res.push(quo1);
        }
        return res;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main class for the program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;
        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result =
                AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        default:
            break;
        }
    }

}
