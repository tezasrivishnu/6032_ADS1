import java.util.Scanner;
class Steque {
	Node head;
	Node tail;
	int size;
	class Node {
		int data;
		Node next;
	}
	Steque() {
		head = null;
		tail = null;
		size = 0;
	}
	public void push(int number) {
		Node node = head;
		head = new Node();
		head.data = number;
		head.next = node;
		if(tail == null) {
			tail = head;
		}
		size ++;
	}
	public void enqueue(int number) {
		Node node = tail;
		tail = new Node();
		tail.data = number;
		tail.next = null;
		if (head == null) {
			head = tail;
		} else {
			node.next = tail;
		}
		size ++;
	}
	public void pop() {
		int num = head.data;
		head = head.next;
		size --;
	}
	public boolean isEmpty() {
		return head == null;
	}
	public int size() {
		return size;
	}
	public void print() {
		String str = "";
		Node node = head;
		for(int i = 0; i<size()-1; i++) {
			str += node.data +  ", ";
		}
		str += node.data;
		System.out.println(str);
	}

}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Steque steque = new Steque();
		int input = scan.nextInt();
		while (scan.hasNext()) {
			String token = scan.nextLine();
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