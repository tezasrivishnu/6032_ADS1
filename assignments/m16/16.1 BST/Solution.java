import java.util.Scanner;
final class Solution {
	private Solution() {

	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		BinaryTree bt = new BinaryTree();
		for (int i = 0; scan.hasNext(); i++) {
			String[] tokens = scan.nextLine().split(",");
			if (tokens[0].equals("put")) {
				bt.put(new BookDetails(tokens[1], tokens[2],
				                       Float.parseFloat(tokens[3])),
				Integer.parseInt(tokens[4]));
			} else if (tokens[0].equals("get")) {
				System.out.println(bt.get(new BookDetails(tokens[1], tokens[2],
				                       Float.parseFloat(tokens[3]))));
			}
		}
	}
}
class BookDetails implements Comparable {
	private String name;
	private String author;
	private float price;

	BookDetails(String bookname, String bookauthor, float bookprice) {
		this.name = bookname;
		this.author = bookauthor;
		this.price = bookprice;
	}
	public String getName() {
		return this.name;
	}
	public String getAuthor() {
		return this.author;
	}
	public float getPrice() {
		return this.price;
	}
	public int compareTo(Object object) {
		BookDetails that = (BookDetails) object;
		return this.name.compareTo(that.name);
	}
}
class Node {
	public BookDetails key;
	public int val;
	public Node left, right;
	public Node(BookDetails key, int val) {
		this.key = key;
		this.val = val;
		left = null;
		right = null;
	}
}

class BinaryTree {
	private Node root;
	BinaryTree() {
		root = null;
	}
	public Node root() {
		return root;
	}
	public int get(BookDetails key) {
		while (root != null) {
			int cmp = key.compareTo(root.key);
			if (cmp < 0) {
				root = root.left;
			} else if (cmp > 0) {
				root = root.right;
			} else if (cmp == 0) {
				return root.val;
			}
		}
		return Integer.parseInt(null);
	}
	public void put(BookDetails key, int val) {
		root = put(root, key, val);
	}
	private Node put(Node x, BookDetails key, int val) {
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
