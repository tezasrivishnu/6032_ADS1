import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
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
class LinkedList {
	private class Node {
		int value;
		Node next;
		Node(int val, Node n) {
			value = val;
			next = n;
		}
		Node(int val) {
			this(val, null);
		}
	}
	Node head;
	Node tail;
	int size;
	public LinkedList() {
		head = null;
		tail = head;
		size = 0;
	}
	public void insertAt(int index, int data) {
		if (index < 0 || index > size) {
			System.out.println("Can't insert at this position.");
			return;
		}
		head = insertAt(head, new Node(data), index, 0);
		System.out.println(toString());
		size++;
	}
	public Node insertAt(Node current, Node node, int index, int till) {
		// int counter = 0;
		// if (index > size || index < 0) {
		// 	System.out.println("Can't insert at this position.");
		// 	return;
		// }
		//Node node = new Node(data);
		if (current == null) {
			//current.data = node;
			current = node;
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
		return head;
		// if (size == 0) {
		// 	head = node;
		// 	tail = head;
		// 	size++;
		// 	System.out.println(toString());
		// 	return;
		// }
		// if (index == 0) {
		// 	node.next = head;
		// 	head = node;
		// 	tail = head;
		// 	size ++;
		// 	System.out.println(toString());
		// 	return;
		// } else if (counter == index) {
		// 	node.next = tail.next;
		// 	tail.next = node;
		// 	tail = head;
		// 	counter = 1;
		// 	size++;
		// 	System.out.println(toString());
		// 	return;
		// }
		// tail = tail.next;
		// counter++;
		// insertAt(index, data);
		// // Node prev = head;
		// // for (int k = 1; k <= index - 1; k++) {
		// // 	prev = prev.next;
		// // }
		// // prev.next = new Node(data, prev.next);
		// // if (prev.next.next == null) {
		// // 	tail = prev.next;
		// // }
		// System.out.println(toString());
	}
	public void reverse() {
		if (size == 0) {
			System.out.println("No elements to reverse.");
			return;
		}
		head = reverse(head);
		System.out.println(toString());
	}
	public Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
		       // Node newnode;
		       // if (node.next == null) {
		       // 	return node;
		       // }
		       // newnode = reverse(node.next);
		       // node.next.next = node;
		       // node.next = null;
		       // return newnode;
	}
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