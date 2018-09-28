import java.util.Scanner;
class LinkedList<E> {
	private class Deque {
		E data;
		Deque next;
		Deque () {
		}

		Deque (E data) {
			this(data, null);
		}

		Deque (E data, Deque next) {
			this.data = data;
			this.next = next;
		}

	}
	private Deque head, tail;
	int size = 0;
	public void pushLeft(E data) {
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
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return head.next == null;
	}

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

	public void pushRight(E data) {
		tail.next = new Deque(data);
		tail = tail.next;
		size++;
		System.out.println(print());
	}

	public void popRight() {
		if (size == 0) {
			System.out.println("Deck is empty");
			return;
		}
		E data = tail.data;
		Deque thead = head;
		while (thead.next != tail)
			thead = thead.next;
		thead.next = null;
		tail = thead;
		size--;
		System.out.println(print());
	}
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
class Solution {
	public static void main(String[] args) {
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