package main.datastructure.queue;

public class QueueLinkedList {
	private Node last;
	private Node first;

	/**
	 * @param data
	 * description We only insert at the end of queue as last node.
	 */
	public void insert(int data) {
		Node newNode = new Node();
		newNode.setData(data);
		//If the last is null that mean this is our first node in the queue. So the newNode becomes the
		//last
		if (last == null) {
			last = newNode;
		}
		//If the last is not null then the the queue is not empty.
		else {
			last.setForwardLink(newNode);
			newNode.setBackwardLink(last);
			last = newNode;
		}

		if (first == null) {
			first = newNode;
		}
	}

	/**
	 * @description We only delete the first element in the queue
	 **/
	public int delete() {
		if (first == null) {
			System.out.println("Queue is empty.");
			return 0;
		}

		int tempData = first.getData();
		if (first.getForwardLink() == null) {
			System.out.println("This is the last node.");
		} else {
			first = first.getForwardLink();
		}
		return tempData;
	}

	public void display() {
		Node node = first;
		do {
			System.out.println(node.getData() + " ");
			node = node.getForwardLink();
		} while (node.getForwardLink() != null);
	}
}