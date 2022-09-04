package main.implementation.medium;


public class SwapNodesInPairs_NC {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		SwapNodesInPairs_NC s = new SwapNodesInPairs_NC();
		s.startAlogorithm();
	}

	public void startAlogorithm() {
		ListNode lHead = new ListNode(-1);
		int[] l1 = new int[]{1, 2, 3, 4};
		ListNode currL1 = lHead;
		for (int i = 0; i < l1.length; i++) {
			ListNode node = new ListNode(l1[i]);
			currL1.next = node;
			currL1 = node;
		}
		swapPairs(lHead);
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}

		swapper(head);
		if(head.next != null) {
			ListNode itertr = head.next;
			while (itertr != null) {
				System.out.println(itertr.val);
				itertr = itertr.next;
			}
		}
		return null;
	}

	private void swapper(ListNode current) {
		if(current == null) {
			return;
		} else {
			if (current.next != null) {
				//1 -> 2 -> 3
				//temp = 2
				//current = 1
				ListNode temp = current.next;
				temp.next = current;
				current.next = temp.next;
				//temp.next = current
				//current.next = temp.next
				swapper(current.next.next);
			}
		}
	}
}
