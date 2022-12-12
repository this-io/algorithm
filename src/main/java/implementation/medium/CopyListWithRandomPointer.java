package implementation.medium;

public class CopyListWithRandomPointer {
	public static void main(String[] args) {
		CopyListWithRandomPointer c = new CopyListWithRandomPointer();

		c.copyRandomList(null);
	}

	public Node copyRandomList(Node head) {

		return null;
	}

	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
