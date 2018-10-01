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
     *
     * @param      number  The number
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
     *
     * @param      number  The number
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
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * getting the size of the steque.
     *
     * @return     the size.
     */
    public int size() {
        return size;
    }
    /**
     * string representation of the nodes data.
     */
    public void print() {
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
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Steque steque = new Steque();
        int input = scan.nextInt();
        while (scan.hasNext()) {
            String token = scan.nextLine();
            if (token.length() == 0) {
                System.out.println();
            } else {
                String[] tokens = token.split(" ");
                switch (tokens[0]) {
                case "push":
                    steque.push(Integer.parseInt(tokens[1]));
                    steque.print();
                    break;
                case "enqueue":
                    steque.enqueue(Integer.parseInt(tokens[1]));
                    steque.print();
                    break;
                case "pop":
                    steque.pop();
                    steque.print();
                    break;
                default:
                    break;
                }
            }
        }
    }
}