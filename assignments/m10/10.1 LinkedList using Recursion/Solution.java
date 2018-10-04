import java.util.Scanner;
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
     * main program for the program.
     * complexity O(n) as we are taking n inputs.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList list = new LinkedList();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "insertAt":
                list.insertAt(Integer.parseInt(tokens[1]),
                              Integer.parseInt(tokens[2]));
                //System.out.println(list.toString());
                break;
            case "reverse":
                list.reverse();
                break;
            default:
                break;
            }
        }
    }
}
/**
 * List of linkeds.
 */
class LinkedList {
    /**
     * Class for node.
     */
    private class Node {
        /**
         * declaring the int value.
         */
        private int value;
        /**
         * declaring node next.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      val   The value
         * @param      n     node.
         */
        Node(final int val, final Node n) {
            value = val;
            next = n;
        }
        /**
         * Constructs the object.
         * complexity O(n) as we are just asigning the values.
         * @param      val   The value
         */
        Node(final int val) {
            this(val, null);
        }
    }
    /**
     * declaring the node head.
     */
    private Node head;
    /**
     * declaring the node tail.
     */
    private Node tail;
    /**
     * declaring the int size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    LinkedList() {
        head = null;
        tail = head;
        size = 0;
    }
    /**
     * helper method.
     * complexity O(n) as we are calling a method once.
     *
     * @param      index  The index at which.
     * @param      data   The data to be inserted.
     */
    public void insertAt(final int index, final int data) {
        System.out.println("here");
        if (index < 0 || index > size) {
            System.out.println("Can't insert at this position.");
            return;
        }
        head = insertAt(head, new Node(data), index, 0);
        System.out.println(toString());
        size++;
    }
    /**
     * inserting at a specified location.
     * complexity O(n) max. if we have to insert at last node.
     * @param      current  head as current node.
     * @param      node     new node with data.
     * @param      index    The index
     * @param      till     The till index
     *
     * @return     node.
     */
    public Node insertAt(final Node current,
        final Node node, final int index,
        final int till) {
        System.out.println("here");
        // int counter = 0;
        // if (index > size || index < 0) {
        //  System.out.println("Can't insert at this position.");
        //  return;
        // }
        //Node node = new Node(data);
        if (current == null) {
            //current.data = node;
            //current = node;
            //System.out.println(toString());
            return node;
        }
        if (index == till) {
            node.next = current;
            //System.out.println(toString());
            return node;
        }
        current.next = insertAt(current.next, node, index, till + 1);
        //System.out.println(toString());
        return current;
        // if (size == 0) {
        //  head = node;
        //  tail = head;
        //  size++;
        //  System.out.println(toString());
        //  return;
        // }
        // if (index == 0) {
        //  node.next = head;
        //  head = node;
        //  tail = head;
        //  size ++;
        //  System.out.println(toString());
        //  return;
        // } else if (counter == index) {
        //  node.next = tail.next;
        //  tail.next = node;
        //  tail = head;
        //  counter = 1;
        //  size++;
        //  System.out.println(toString());
        //  return;
        // }
        // tail = tail.next;
        // counter++;
        // insertAt(index, data);
        // // Node prev = head;
        // // for (int k = 1; k <= index - 1; k++) {
        // //   prev = prev.next;
        // // }
        // // prev.next = new Node(data, prev.next);
        // // if (prev.next.next == null) {
        // //   tail = prev.next;
        // // }
        // System.out.println(toString());
    }
    /**
     * helper method.
     * complexity O(n) we are calling a method once.
     */
    public void reverse() {
        System.out.println("here");
        if (size == 0) {
            System.out.println("No elements to reverse.");
            return;
        }
        head = reverse(head);
        System.out.println(toString());
    }
    /**
     * reverse of the linked list.
     *complexity O(n) since we are reversing the full list.
     * @param      node  node head.
     *
     * @return     node
     */
    public Node reverse(final Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        //node = prev;
        return prev;
               // Node newnode;
               // if (node.next == null) {
               //   return node;
               // }
               // newnode = reverse(node.next);
               // node.next.next = node;
               // node.next = null;
               // return newnode;
    }
    /**
     * Returns a string representation of the object.
     * comlexity (N) as we are printing all the data.
     * @return     String representation of the object.
     */
    public String toString() {
        Node temp = head;
        String str = "";
        while (temp.next != null) {
            str += temp.value + ", ";
            temp = temp.next;
        }
        str += temp.value;
        return str;
    }
}
