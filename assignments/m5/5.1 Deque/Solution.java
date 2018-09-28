import java.util.Scanner;
/**
 * Linked list.
 *
 * @param      <E>   the Data Type class.
 */
class LinkedList<E> {
    /**
     * Class for deque.
     */
    private class Deque {
        /**
         * initializing the variable data of type E.
         */
        private E data;
        /**
         * initializing class variable.
         */
        private Deque next;
        /**
         * Constructs the object.
         */
        Deque() {
        }
        /**
         * Constructs the object.
         *
         * @param      data  The data
         */
        Deque(final E data) {
            this(data, null);
        }
        /**
         * Constructs the object.
         *
         * @param      datainp  The data
         * @param      nextadrress  The next
         */
        Deque(final E datainp, final Deque nextaddress) {
            this.data = datainp;
            this.next = nextaddress;
        }
    }
    /**
     * initializing the nodes head and tail.
     */
    private Deque head, tail;
    /**
     * initializing the size.
     */
    private int size = 0;
    /**
     * adds a element at the start.
     *
     * @param      data  The data
     */
    public void pushLeft(final E data) {
        Deque deque = new Deque();
        deque.data = data;
        deque.next = head;
        if (head == null) {
            head = deque;
            tail = head;
            size += 1;
            System.out.println(print());
            return;
        }
        size += 1;
        head = deque;
        System.out.println(print());
    }
    /**
     * return the size of a array.
     *
     * @return     the size.
     */
    public int size() {
        return size;
    }
    /**
     * checking of stack is empty or not.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head.next == null;
    }
    /**
     * eleminating the element at start.
     */
    public void popLeft() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        E data = head.data;
        head = head.next;
        size--;
        System.out.println(print());
    }
    /**
     * adding element at the end of stack.
     *
     * @param      data  The data
     */
    public void pushRight(final E data) {
        tail.next = new Deque(data);
        tail = tail.next;
        size++;
        System.out.println(print());
    }
    /**
     * eleminating the ending node.
     */
    public void popRight() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        E data = tail.data;
        Deque thead = head;
        while (thead.next != tail) {
            thead = thead.next;
        }
        thead.next = null;
        tail = thead;
        size--;
        System.out.println(print());
    }
    /**
     * string representaton of the stack.
     *
     * @return     string representation.
     */
    public String print() {
        Deque thead = head;
        if (size == 0) {
            return "[]";
        }
        String str = "[";
        while (thead.next != null) {
            str += thead.data + ", ";
            thead = thead.next;
        }
        str += thead.data + "]";
        return str;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main class for class solution.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        LinkedList<Integer> link = new LinkedList<Integer>();
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        while (scan.hasNext()) {
            String input = scan.nextLine();
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
            case "pushLeft":
                link.pushLeft(Integer.parseInt(tokens[1]));
                break;
            case "pushRight":
                link.pushRight(Integer.parseInt(tokens[1]));
                break;
            case "size":
                System.out.println(link.size());
                break;
            case "popLeft":
                link.popLeft();
                break;
            case "popRight":
                link.popRight();
                break;
            case "isEmpty":
                System.out.println(link.isEmpty());
                break;
            case "print":
                System.out.println(link.print());
                break;
            default:
                break;
            }
        }
    }
}