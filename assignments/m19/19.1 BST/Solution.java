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
				                     tokens[3]), Integer.parseInt(tokens[4]));
				break;
			case "get":
				int output = bst.get(new BookInfo(tokens[1],
				                                  tokens[2],
				                                  tokens[3]));
				System.out.println(output);
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
				                                     tokens[1], tokens[2], tokens[3]));
				System.out.println(floor.toString());
				break;
			case "ceiling":
				Comparable ceiling = bst.ceiling(new BookInfo(
				                                     tokens[1], tokens[2], tokens[3]));
				System.out.println(ceiling.toString());
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
	public int compareTo(BookInfo that) {
		return this.getName().compareTo(that.getName());
	}
	// public String getQuantity() {
	// 	return this.bookquantity;
	// }
}
/**
 * Class for bst.
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
	public void put(BookInfo book, int value) {
		root = put(root, book, value);
	}
	public Node put(Node rtemp, BookInfo book, int value) {
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
	public int get(BookInfo book) {
		return get(root, book);
	}
	public int get(Node rtemp, BookInfo book) {
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
	public int size() {
		return size(root);
	}
	public int size(Node rtemp) {
		if (rtemp == null) {
			return 0;
		} else {
			return rtemp.size;
		}
	}
	public BookInfo min() {
		return min(root).book;
	}

	public Node min(Node rtemp) {
		if (rtemp.left == null) {
			return rtemp;
		} else {
			return min(rtemp.left);
		}
	}
	public BookInfo max() {
		return max(root).book;
	}
	public Node max(Node rtemp) {
		if (rtemp.right == null) {
			return rtemp;
		} else {
			return max(rtemp.right);
		}
	}
	public BookInfo select(int select) {
		Node rtemp = select(root, select);
		return rtemp.book;
	}
	public Node select(Node rtemp, int select) {
		int value = size(rtemp.left);
		if (value > select) {
			return select(rtemp.left,  select);
		} else if (value < select) {
			return select(rtemp.right, select - value - 1);
		} else {
			return rtemp;
		}
	}
	public BookInfo ceiling(BookInfo book) {
		Node rtemp = ceiling(root, book);
		return rtemp.book;
	}
	public Node ceiling(Node rtemp, BookInfo book) {
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
	public BookInfo floor(BookInfo book) {
		Node x = floor(root, book);
		return x.book;
	}

	private Node floor(Node rtemp, BookInfo book) {
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
}