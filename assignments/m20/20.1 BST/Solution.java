import java.util.Scanner;
/**
 * class for Solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method for the program.
     * complexity O(n) as we are taking n inputs.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BST bst = new BST();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                bst.put(new BookInfo(tokens[1], tokens[2],
                tokens[2 + 1]), Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                int output = bst.get(new BookInfo(tokens[1],
                    tokens[2],
                                   tokens[2 + 1]));
                if (output == 0) {
                    System.out.println("null");
                } else {
                    System.out.println(output);
                }
                break;
            case "max":
                Comparable maxbook = bst.max();
                System.out.println(maxbook.toString());
                break;
            case "min":
                Comparable minbook = bst.min();
                System.out.println(minbook.toString());
                break;
            case "select":
                Comparable select = bst.select(Integer.
                        parseInt(tokens[1]));
                System.out.println(select.toString());
                break;
            case "floor":
                Comparable floor = bst.floor(new BookInfo(
                        tokens[1], tokens[2], tokens[2 + 1]));
                if (floor == null) {
                    System.out.println("null");
                } else {
                    System.out.println(floor.toString());
                }
                break;
            case "ceiling":
                Comparable ceiling = bst.ceiling(new BookInfo(
                            tokens[1], tokens[2], tokens[2 + 1]));
                if (ceiling == null) {
                    System.out.println("null");
                } else {
                    System.out.println(ceiling.toString());
                }
                break;
            case "delete":
                bst.delete(new BookInfo(tokens[1], tokens[2],
                                        tokens[2 + 1]));
                break;
            case "deleteMin":
                bst.deleteMin();
                break;
            case "deleteMax":
                bst.deleteMax();
                break;
            default:
                break;
            }
        }
    }
}
/**
 * Class for book information.
 */
class BookInfo implements Comparable<BookInfo> {
    /**
     * intialising the string book name.
     */
    private String bookname;
    /**
     * intialising the string book author.
     */
    private String bookauthor;
    /**
     * intialising the string book price.
     */
    private String bookprice;
    //private String bookquantity;

    /**
     * Constructs the object.
     *
     * @param      name    The name string type
     * @param      author  The author string type
     * @param      price   The price string type
     */
    BookInfo(final String name, final String author,
             final String price) {
        this.bookname = name;
        this.bookauthor = author;
        this.bookprice = price;
        //this.bookquantity = quantity;
    }
    /**
     * Gets the name of the book.
     * complexity O(1) as we are reurning the book name.
     * @return     bookname.
     */
    public String getName() {
        return this.bookname;
    }
    /**
     * Gets the author of the book.
     * complexity O(1) as we are reurning the book author.
     * @return     bookauthor.
     */
    public String getAuthor() {
        return this.bookauthor;
    }
    /**
     * Gets the price of the book.
     * complexity O(1) as we are reurning the book price.
     * @return     bookprice.
     */
    public String getPrice() {
        return this.bookprice;
    }
    /**
     * Returns a string representation
     * of the object data.
     * complexity O(1) as we are printing
     * only one object data.
     * @return     String representation of the object data.
     */
    public String toString() {
        return this.getName() + ", "
               + this.getAuthor() + ", "
               + Float.parseFloat(this.getPrice());
    }
    /**
     * comparing two objects names.
     * complexity O(1) as we are comparing two objects.
     * @param      that  The that bookinfo object.
     *
     * @return     the value after comparision.
     */
    public int compareTo(final BookInfo that) {
        return this.getName().compareTo(that.getName());
    }
    // public String getQuantity() {
    //  return this.bookquantity;
    // }
}
/**
 * Class for bst.
 *
 * @param      <BookInfo>  The book information class
 */
class BST<BookInfo extends Comparable<BookInfo>> {
    /**
     * intialising the node object root.
     */
    private Node root;
    /**
     * Class for node.
     */
    class Node {
        /**
         * initializing the bookinfo object book.
         */
        private BookInfo book;
        /**
         * intializing the value variable.
         */
        private int value;
        /**
        * intialising the node object left.
        */
        private Node left;
        /**
        * intialising the node object right.
        */
        private Node right;
        /**
         * intializing the size variable.
         */
        private int size;
        /**
         * Constructs the object.
         *
         * @param      key    The key bookinfo object
         * @param      val    The value int type
         * @param      count  The count int type
         */
        Node(final BookInfo key, final int val,
             final int count) {
            this.book = key;
            this.value = val;
            this.size = count;
        }
    }
    /**
     * Constructs the object.
     */
    BST() {

    }
    /**
     * helper method for put.
     * complexity is h(height of the tree) as time
     * comlexity of main get method
     * is h(height of the tree)
     * @param      book   The book bookinfo object
     * @param      value  The value  int type.
     */
    public void put(final BookInfo book,
                    final int value) {
        root = put(root, book, value);
    }
    /**
     * we are adding an book info object to the tree.
     * complexity is h , where h is the height of the tree.
     * @param      rtemp  The rtemp node object
     * @param      book   The book bookinfo object
     * @param      value  The value int type
     *
     * @return     the node object.
     */
    public Node put(final Node rtemp, final BookInfo book,
                    final int value) {
        if (rtemp == null) {
            return new Node(book, value, 1);
        }
        int cvalue = book.compareTo(rtemp.book);
        if (cvalue < 0) {
            rtemp.left  = put(rtemp.left,  book, value);
        } else if (cvalue > 0) {
            rtemp.right = put(rtemp.right, book, value);
        } else {
            rtemp.value   = value;
        }
        rtemp.size = 1 + size(rtemp.left) + size(rtemp.right);
        return rtemp;
    }
    /**
     * helper method fpr the main get method.
     * complexity is h(height of the tree) as time
     * comlexity of main get method
     * is h(height of the tree)
     * @param      book  The book
     *
     * @return     the int value.
     */
    public int get(final BookInfo book) {
        return get(root, book);
    }
    /**
     * we are returning the place of book object in the tree.
     * complexity is h , where h is the height of the tree.
     * @param      rtemp  The rtemp node object
     * @param      book   The book bookinfo object.
     *
     * @return     int value.
     */
    public int get(final Node rtemp, final BookInfo book) {
        if (rtemp == null) {
            return 0;
        }
        int cvalue = book.compareTo(rtemp.book);
        if (cvalue < 0) {
            return get(rtemp.left, book);
        } else if (cvalue > 0) {
            return get(rtemp.right, book);
        } else {
            return rtemp.value;
        }
    }
    /**
     * helper method for the main size method.
     * complexity O(1) as the complexity
     * of the size method is 1.
     * @return     size.
     */
    public int size() {
        return size(root);
    }
    /**
     * calculating the size of the node element.
     * complexity (1) as we are just returning the size of the tree.
     * @param      rtemp  The rtemp
     *
     * @return     size.
     */
    public int size(final Node rtemp) {
        if (rtemp == null) {
            return 0;
        } else {
            return rtemp.size;
        }
    }
    /**
     * helper method for main min method.
     * complexity is h(height of the tree) as time
     * comlexity of main get method
     * is h(height of the tree)
     * @return     bookinfo object
     */
    public BookInfo min() {
        return min(root).book;
    }
    /**
     * finding the min element in the tree.
     * complexity is h , where h is the height of the tree.
     * @param      rtemp  node object
     *
     * @return     node object.
     */
    public Node min(final Node rtemp) {
        if (rtemp.left == null) {
            return rtemp;
        } else {
            return min(rtemp.left);
        }
    }
    /**
     * helper method for main max method.
     * complexity is h(height of the tree) as time
     * comlexity of main get method
     * is h(height of the tree)
     * @return     bookinfo object
     */
    public BookInfo max() {
        return max(root).book;
    }
    /**
     * finding the max element in the tree.
     * complexity is h , where h is the height of the tree.
     * @param      rtemp  node object
     *
     * @return     node object.
     */
    public Node max(final Node rtemp) {
        if (rtemp.right == null) {
            return rtemp;
        } else {
            return max(rtemp.right);
        }
    }
    /**
     * helper method for the main select method.
     * complexity is h(height of the tree) as time
     * comlexity of main get method
     * is h(height of the tree)
     * @param      select  The select int type
     *
     * @return     bookinfo object
     */
    public BookInfo select(final int select) {
        Node rtemp = select(root, select);
        return rtemp.book;
    }
    /**
     * we are finding the nth smallest element in tree.
     * complexity is h , where h is the height of the tree.
     * @param      rtemp   The rtemp node object
     * @param      select  The select int type
     *
     * @return     node object
     */
    public Node select(final Node rtemp,
                       final int select) {
        int value = size(rtemp.left);
        if (value > select) {
            return select(rtemp.left,  select);
        } else if (value < select) {
            return select(rtemp.right, select - value - 1);
        } else {
            return rtemp;
        }
    }
    /**
     * helper method for the ceiling.
     * complexity is h(height of the tree) as time
     * comlexity of main get method
     * is h(height of the tree)
     * @param      book  The bookinfo object
     *
     * @return     the bookinfo object.
     */
    public BookInfo ceiling(final BookInfo book) {
        Node rtemp = ceiling(root, book);
        if (rtemp == null) {
            return null;
        } else {
            return rtemp.book;
        }
    }
    /**
     * finding the before element of the key.
     * complexity is h , where h is the height of the tree.
     * @param      rtemp  The rtemp node object
     * @param      book   The book bookinfo object.
     *
     * @return     the Node object
     */
    public Node ceiling(final Node rtemp, final BookInfo book) {
        if (rtemp == null) {
            return null;
        }
        int cvalue = book.compareTo(rtemp.book);
        if (cvalue == 0) {
            return rtemp;
        }
        if (cvalue < 0) {
            Node temp = ceiling(rtemp.left, book);
            if (temp != null) {
                return temp;
            } else {
                return rtemp;
            }
        }
        return ceiling(rtemp.right, book);
    }
    /**
     * helper method for the floor.
     * complexity is h(height of the tree) as time
     * comlexity of main get method
     * is h(height of the tree)
     * @param      book  The book
     *
     * @return     the bookinfo object.
     */
    public BookInfo floor(final BookInfo book) {
        Node x = floor(root, book);
        if (x == null) {
            return null;
        } else {
            return x.book;
        }
    }
    /**
     * finding the next element of the element.
     * complexity is h , where h is the height of the tree.
     * @param      rtemp  The rtemp
     * @param      book   The book
     *
     * @return     the Node object
     */
    public Node floor(final Node rtemp, final BookInfo book) {
        if (rtemp == null) {
            return null;
        }
        int cvalue = book.compareTo(rtemp.book);
        if (cvalue == 0) {
            return rtemp;
        }
        if (cvalue <  0) {
            return floor(rtemp.left, book);
        }
        Node temp = floor(rtemp.right, book);
        if (temp != null) {
            return temp;
        } else {
            return rtemp;
        }
    }
    /**
     * helper method for the main deletemin method.
     * complexity is h(height of the tree) as time
     * comlexity of main deletemin method
     * is h(height of the tree)
     */
    public void deleteMin() {
        root = deleteMin(root);
    }
    /**
     * deleting the minimum element in the tree.
     * complexity is h, where h is the height of the tree
     *
     * @param      rtemp  The rtemp
     *
     * @return     node object.
     */
    public Node deleteMin(final Node rtemp) {
        if (rtemp.left == null) {
            return rtemp.right;
        }
        rtemp.left = deleteMin(rtemp.left);
        rtemp.size = size(rtemp.left) + size(rtemp.right) + 1;
        return rtemp;
    }
    /**
     * helper method for the main deletemax method.
     * complexity is h(height of the tree) as time
     * comlexity of main deletemax method
     * is h(height of the tree)
     */
    public void deleteMax() {
        root = deleteMax(root);
    }
    /**
     * deleting the maximum element in the tree.
     * complexity is h, where h is the height of the tree
     *
     * @param      rtemp  The rtemp
     *
     * @return     node object.
     */
    public Node deleteMax(final Node rtemp) {
        if (rtemp.right == null) {
            return rtemp.left;
        }
        rtemp.right = deleteMax(rtemp.right);
        rtemp.size = size(rtemp.left) + size(rtemp.right) + 1;
        return rtemp;
    }
    /**
     * helper method for the main delete method.
     * complexity is h(height of the tree) as time
     * comlexity of main delete method
     * is h(height of the tree)
     * @param book bookinfo object.
     */
    public void delete(final BookInfo book) {
        root = delete(root, book);
    }
    /**
     * deleting an in the tree.
     * complexity is h, where h is the height of the tree
     *
     * @param      rtemp  The rtemp
     * @param      book book info object
     * @return     node object.
     */
    public Node delete(final Node rtemp, final BookInfo book) {
        if (rtemp == null) {
            return null;
        }
        int cmp = book.compareTo(rtemp.book);
        if      (cmp < 0) {
            rtemp.left  = delete(rtemp.left,  book);
        } else if (cmp > 0) {
            rtemp.right = delete(rtemp.right, book);
        } else {
            if (rtemp.right == null) {
                return rtemp.left;
            }
            if (rtemp.left  == null) {
                return rtemp.right;
            }
            Node temp = rtemp;
            temp = min(temp.right);
            rtemp.right = deleteMin(temp.right);
            rtemp.left = temp.left;
        }
        rtemp.size = size(rtemp.left) + size(rtemp.right) + 1;
        return rtemp;
    }
}
