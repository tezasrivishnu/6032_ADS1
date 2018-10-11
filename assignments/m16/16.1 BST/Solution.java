import java.util.Scanner;
/**
 * class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method for the progrm.
     * complexity O(n) as we are taking n inputs.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        for (int i = 0; scan.hasNext(); i++) {
            String[] tokens = scan.nextLine().split(",");
            if (tokens[0].equals("put")) {
                bt.put(new BookInformtion(tokens[1], tokens[2],
                                          Float.parseFloat(tokens[3])),
                       Integer.parseInt(tokens[4]));
            } else if (tokens[0].equals("get")) {
                System.out.println(bt.get(new BookInformtion(tokens[1], tokens[2],
                                          Float.parseFloat(tokens[3]))));
            }
        }
    }
}
/**
 * Class for book informtion.
 */
class BookInformtion implements Comparable {
    /**
     * initalizing the string name.
     */
    private String name;
    /**
     * initalizing the string author.
     */
    private String author;
    /**
     * initalizing the float value price.
     */
    private float price;
    /**
     * Constructs the object.
     *
     * @param      bookname    The bookname
     * @param      bookauthor  The bookauthor
     * @param      bookprice   The bookprice
     */
    BookInformtion(final String bookname, final String bookauthor,
                   final float bookprice) {
        this.name = bookname;
        this.author = bookauthor;
        this.price = bookprice;
    }
    /**
     * Gets the name of the book.
     * complexity O(1) as we are just
     * returning the name of book.
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the author of the book.
     * complexity O(1) as we are just
     * returning the author of book.
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Gets the price of the book.
     * complexity O(1) as we are just
     * returning the price of book.
     * @return     The price.
     */
    public float getPrice() {
        return this.price;
    }
    public int compareTo(final Object object) {
        BookInformtion that = (BookInformtion) object;
        return this.name.compareTo(that.name);
    }
}
/**
 * Class for node.
 */
class Node {

    /**
     * initiazing the bookinformation class object.
     */
    public BookInformtion key;
    /**
     * initiazing the int value.
     */
    public int val;
    /**
     * initiazing the node class objects.
     */
    public Node left, right;
    /**
     * Constructs the object.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public Node(final BookInformtion key,
                final int val) {
        this.key = key;
        this.val = val;
        left = null;
        right = null;
    }
}
/**
 * Class for binary tree.
 */
class BinaryTree {
    /**
     * initializing root node.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    BinaryTree() {
        root = null;
    }
    /**
     *
     * returning the root node of the tree.
     * complexity O(1) we are just returing the value.
     * @return     root node.
     */
    public Node root() {
        return root;
    }
    /**
     * getting the quantity of the book
     * complexity O(n) as we might search
     * the full tree to get the element.
     * @param      key   The key
     *
     * @return     the quantity.
     */
    public int get(final BookInformtion key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else if (cmp == 0) {
                return x.val;
            }
        }
        return Integer.parseInt(null);
    }
    /**
     * helper method.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final BookInformtion key, int val) {
        root = put(root, key, val);
    }
    /**
     * inserting a element in the tree.
     * complexity O(n) we must go through each and every parent node.
     * @param      x     Node
     * @param      key   The Book information key
     * @param      val   The value
     *
     * @return     the node.
     */
    private Node put(final Node x,
                     final BookInformtion key, final int val) {
        if (x == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp == 0) {
            x.val = val;
        }
        return x;
    }
}
