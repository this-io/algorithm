package implementation.medium.lru;

public class DoubleLinkedList {
	//1. Previous of node is always null
	public Node head;
	//1. Next of Tail is always null.
	public Node tail;

	public Node addNode(int key, int value) {
		Node node = createNode(key, value);
		//If head is null that mean DLL is not initialized yet.
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.previous = tail;
			tail = node;
		}
		return node;
	}

	public void toHead(Node node) {
		if(node == null) {
			return;
		}
		//Now the argument can be head, tail or something in between.
		//if head do not do anything as we are already at head.
		if(node == head) {
			//do nothing
		} else if (node == tail) {
			tail.next = head;
			head.previous = tail;
			head = tail;
			tail = tail.previous;
			tail.next = null;
			head.previous = null;
		} else {
			node.previous.next = node.next;
			node.next.previous = node.previous;
			node.next = head;
			head.previous = node;
			head = node;
			node.previous = null;
		}
	}

	public Node removeTail() {
		if(tail == null) {
			return null;
		}

		if(head == tail) {
			Node tempHead = head;
			head = null;
			tail = null;
			return tempHead;
		}
		Node tempNode = tail;
		tail = tail.previous;
		tail.next = null;

		return tempNode;
	}

	public int peak() {
		return tail.key;
	}

	public void display() {
		Node node = head;

		while (node != null) {
			System.out.print(node.key + " ");
			node = node.next;
		}
	}

	private Node createNode(int key, int value) {
		Node node = new Node();
		node.key = key;
		node.value = value;

		return node;
	}
}
