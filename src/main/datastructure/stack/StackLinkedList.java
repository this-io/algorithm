package main.datastructure.stack;

public class StackLinkedList {
	public Node top;
	public class Node {
		private int data;
		private Node link;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLink() {
			return link;
		}

		public void setLink(Node link) {
			this.link = link;
		}
	}

	public Node add(int data) {
		Node node = new Node();
		node.setData(data);
		node.setLink(top);
		top = node;
		return node;
	}

	public Node delete() {
		if(top == null) {
			System.out.println("Stack is empty.");
			return top;
		}

		Node temp = top;
		Node previous = top.getLink();
		top = previous;
		return temp;
	}

	public void printList() {
		Node tnode = top;
		while (tnode != null) {
			System.out.print(tnode.data+"\n");
			tnode = tnode.getLink();
		}
	}
}
