class LinkedList<E> {
    // /**
    //  * Class for deque.
    //  */
    // private class Node {
    //     /**
    //      * initializing the variable data of type E.
    //      */
    //     private E data;
    //     /**
    //      * initializing class variable.
    //      */
    //     private Node next;
    //     /**
    //      * Constructs the object.
    //      */
    //     Node() {
    //     }
    //     /**
    //      * Constructs the object.
    //      *
    //      * @param      datainp  The data
    //      */
    //     Node(final E datainp) {
    //         this(datainp, null);
    //     }
    //     /**
    //      * Constructs the object.
    //      *
    //      * @param      datainp  The data
    //      * @param      nextaddress  The next
    //      */
    //     Node(final E datainp, final Node nextaddress) {
    //         this.data = datainp;
    //         this.next = nextaddress;
    //     }
    // }
    // /**
    //  * initializing the nodes head and tail.
    //  */
    // private Node head, tail;
    // /**
    //  * initializing the size.
    //  */
    // private int size = 0;
    // /**
    //  * adds a element at the start.
    //  *
    //  * @param      data  The data
    //  */
    // public void pushLeft(final E data) {
    //     Node node = new Node();
    //     node.data = data;
    //     node.next = head;
    //     if (head == null) {
    //         head = node;
    //         tail = head;
    //         size += 1;
    //         //System.out.println(print());
    //         return;
    //     }
    //     size += 1;
    //     head = node;
    //     //System.out.println(print());
    // }
    // /**
    //  * return the size of a array.
    //  *
    //  * @return     the size.
    //  */
    // public int size() {
    //     return size;
    // }
    // /**
    //  * checking of stack is empty or not.
    //  *
    //  * @return     True if empty, False otherwise.
    //  */
    // public boolean isEmpty() {
    //     return head.next == null;
    // }
    // /**
    //  * eleminating the element at start.
    //  */
    // public void popLeft() {
    //     if (size == 0) {
    //         System.out.println("Deck is empty");
    //         return;
    //     }
    //     E data = head.data;
    //     head = head.next;
    //     size--;
    //     //System.out.println(print());
    // }
    // /**
    //  * adding element at the end of stack.
    //  *
    //  * @param      data  The data
    //  */
    // public void pushRight(final E data) {
    //     Node node = new Node();
    //     node.data = data;
    //     if (head == null) {
    //         head = node;
    //         tail = head;
    //         size += 1;
    //         //System.out.println(print());
    //         return;
    //     }
    //     tail.next = null;
    //     tail = node;
    //     size++;
    //     // }

    //     // tail = tail.next;
    //     // size++;
    //     //System.out.println(print());
    // }
    // /**
    //  * eleminating the ending node.
    //  */
    // public E popRight() {

    //     //E data = tail.data;
    //     Node thead = head;
    //     if(thead.next == null) {
    //         size--;
    //         return thead.data;
    //     }
    //     while (thead.next != null) {
    //         thead = thead.next;
    //     }
    //     tail = thead;
    //     size--;
    //     return thead.data;
    //     //System.out.println(print());
    // }
    private class Element {
        // The data value of the element
        private E data;
        // The next element in the stack
        private Element next;

        Element(E data) {
            this.data = data;
            this.next = null;
        }
    }

    // The element at the top of the stack
    private Element top;

    /** Create an empty stack **/
    public LinkedList() {
        this.top = null;
    }

    /** @return true if the stack is empty, false if it is not.
    **/
    public boolean isEmpty() {
        return top == null;
    }

    /**
        Pushes a value onto the top of the stack.
        @param value The data for the stack's new top element.
    **/
    public void push(E value) {
        // Create new top element
        Element newTop = new Element(value);

        // If the stack is not empty
        if (!isEmpty()) {
            // Set old top's next variable to point to new top
            newTop.next = top;
        }

        // Set new top regardless of whether or not stack is empty
        this.top = newTop;
    }

    /**
        Remove the element at the top of the stack.
        @return the data associated with the stack's topmost element being removed.
        @throws EmptyStackException if the stack contains no elements.
    **/
    public E pop() {
        Element oldTop = top;
        this.top = top.next;
        return oldTop.data;
    }
    /**
        'View' the element at the top of the stack.
        @return the data associated with the stack's topmost element.
        @throws EmptyStackException if the stack contains no elements.
    **/
    public E peek() {

        return top.data;
    }
}