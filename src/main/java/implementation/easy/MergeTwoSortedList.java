package implementation.easy;

import java.util.List;

public class MergeTwoSortedList {
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
		MergeTwoSortedList m = new MergeTwoSortedList();
		m.startAlogorithm();
	}

	public void startAlogorithm() {
		ListNode l1Head = new ListNode(-1);
		ListNode l2Head = new ListNode(-1);
		int[] l1 = new int[]{1, 3};
		int[] l2 = new int[]{2};
		ListNode currL1 = l1Head;
		ListNode currl2 = l2Head;
		for (int i = 0; i < l1.length; i++) {
			ListNode node = new ListNode(l1[i]);
			currL1.next = node;
			currL1 = node;
		}

		for (int i = 0; i < l2.length; i++) {
			ListNode node = new ListNode(l2[i]);
			currl2.next = node;
			currl2 = node;
		}

		mergeTwoLists(l1Head.next, l2Head.next);
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		}

		if (list1 == null) {
			return list2;
		}

		if (list2 == null) {
			return list1;
		}
		ListNode op = new ListNode(-1);
		sort(list1, list2, op);

		ListNode itertr = op;
		ListNode previous = null;
		while (itertr != null) {
			if(itertr.next == null) {
				previous.next = null;
			}
			previous = itertr;
			System.out.println(itertr.val);
			itertr = itertr.next;
		}
		return op;
	}

	public void sort(ListNode l1, ListNode l2, ListNode temp) {
		ListNode nextTemp = new ListNode();
		//This means exit criteria for the recursion
		if (l1 == null && l2 == null) {
			return;
		} else if (l1 == null && l2 != null) {
			//this means if l1 is null that mean we have exhausted l1 list and only
			//l2 is remaining, so get all the l2 in output
			temp.val = l2.val;
			temp.next = nextTemp;
			sort(l1, l2.next, nextTemp);
		} else if (l2 == null && l1 != null) {
			//this means if l2 is null that mean we have exhausted l1 list and only
			//l1 is remaining, so get all the l1 in output
			temp.val = l1.val;
			temp.next = nextTemp;
			sort(l1.next, l2, nextTemp);
		} else if (l1.val <= l2.val) {
			temp.val = l1.val;
			temp.next = nextTemp;
			sort(l1.next, l2, nextTemp);
		} else {
			temp.val = l2.val;
			temp.next = nextTemp;
			sort(l1, l2.next, nextTemp);
		}
		return;
	}
}
