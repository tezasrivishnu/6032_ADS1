import java.util.Scanner;
class AddLargeNumbers {
    public static LinkedList numberToDigits(String number) {
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

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
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
            input = quo1 + Integer.parseInt(String.valueOf(ch)) + Integer.parseInt(String.valueOf(ch1));
            quo1 = 0;
            //System.out.println("input "+input);
            if (input >= 10) {
                int reamin = input % 10;
                int quo = input / 10;
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
            if (input >= 10) {
                int reamin = input % 10;
                int quo = input / 10;
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
            if (input >= 10) {
                int reamin = input % 10;
                int quo = input / 10;
                quo1 = quo;
                result = reamin;
                res.push(result);
            } else {
                result = input;
                res.push(result);
            }
        }
        if(quo1 > 0) {
            res.push(quo1);
        }
        return res;
    }
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
        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result =
                AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        }
    }

}
