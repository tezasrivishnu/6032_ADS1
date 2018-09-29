import java.util.Scanner;
class AddLargeNumbers {
    public static LinkedList numberToDigits(String number) {
        LinkedList<Character> str = new LinkedList<Character>();
        String input = number;
        for (int i = 0; i < input.length(); i++) {
            str.push(input.charAt(i));
        }
        LinkedList<Character> str1 = new LinkedList<Character>();
        while(!str.isEmpty()) {
            str1.push(str.pop());
        }
        return str1;
    }

    public static String digitsToNumber(LinkedList list) {
        String string = "";
        // for (int i = 0; i < list.size(); i++) {
        //     string = string + list.pop();
        // }
        while (!(list.isEmpty())) {
        string = string + list.pop();
        }
        return string;
    }

    // public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {

    // }
}

public class Solution {
    public static void main(String[] args) {
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

            // case "addLargeNumbers":
            //     pDigits = AddLargeNumbers.numberToDigits(p);
            //     qDigits = AddLargeNumbers.numberToDigits(q);
            //     LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            //     System.out.println(AddLargeNumbers.digitsToNumber(result));
            //     break;
        }
    }

}
