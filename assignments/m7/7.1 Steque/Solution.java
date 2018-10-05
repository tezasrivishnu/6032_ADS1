import java.util.Scanner;
/**
 * Class for steque.
 * @author tezasrivishnu.
 */
class Steque {
    /**
     * declaring the head node.
     */
    private Node head;
    /**
     * declaring the tail node.
     */
    private Node tail;
    /**
     * declaring the size variable.
     */
    private int size;
    /**
     * Class for node.
     */
    class Node {
        /**
        * declaring the int data.
        */
        private int data;
        /**
        * declaring the next node.
        */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    Steque() {
        head = null;
        tail = null;
        size = 0;
    }
    /**
     * adding element at head.
     * complexity O(1).
     * because we are just adding one element to the steque.
     * @param      number  int
     */
    public void push(final int number) {
        Node node = head;
        head = new Node();
        head.data = number;
        head.next = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }
    /**
     * adding a element at the tail.
     * complexity O(1).
     * because we are just adding one element to the steque.
     * @param      number  int
     */
    public void enqueue(final int number) {
        Node node = tail;
        tail = new Node();
        tail.data = number;
        tail.next = null;
        if (head == null) {
            head = tail;
        } else {
            node.next = tail;
        }
        size++;
    }
    /**
     * removing the link of the last node in steque.
     * complexity O(1).
     * because we are just removing one element from the steque.
     */
    public void pop() {
        if (size == 0) {
            return;
        }
        //int num = head.data;
        head = head.next;
        size--;
    }
    /**
     * checks if steque is empty or not.
     * complexity O(1).
     * ckecking the head so the complexity is one.
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * getting the size of the steque.
     * complexity O(1).
     * because we are just returning the size.
     * @return     the size.
     */
    public int size() {
        return size;
    }
    /**
     * clearing the steque.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    /**
     * string representation of the nodes data.
     * complexity O(N).
     * because we are iterating through complete steque.
     */
    public void toPrint() {
        if (size == 0) {
            System.out.println("Steque is empty.");
            return;
        }
        String str = "";
        Node node = head;
        while (node.next != null) {
            str += node.data +  ", ";
            node = node.next;
        }
        // str += node.data;
        // for(int i = 0; i<size()-1; i++) {
        //  str += node.data +  ", ";
        // }
        str += node.data;
        System.out.println(str);
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
     * main program for the problem.
     * complexity O(N)
     * we are taking input N times.
     * @param      args  String.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Steque steque = new Steque();
        String input = scan.nextLine();
        while (scan.hasNext()) {
            // String token = scan.nextLine();
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[0].length() == 0) {
                steque.clear();
                System.out.println();
            }
            switch (tokens[0]) {
            case "push":
                steque.push(Integer.parseInt(tokens[1]));
                steque.toPrint();
                break;
            case "enqueue":
                steque.enqueue(Integer.parseInt(tokens[1]));
                steque.toPrint();
                break;
            case "pop":
                steque.pop();
                steque.toPrint();
                break;
            default:
                break;
            }
        }
    }
}
