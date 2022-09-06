package main.implementation.hard.heap;

import java.util.*;

public class MergeKSortedLists {
  public static void main(String[] args) {
    MergeKSortedLists m = new MergeKSortedLists();
    m.startProcess();
  }

  public void startProcess() {
    int N = 3;

    // array to store head of linkedlist
    ListNode[] a = new ListNode[N];

    // Linkedlist1
    ListNode head1 = new ListNode(1);
    a[0] = head1;
    head1.next = new ListNode(3);
    head1.next.next = new ListNode(5);
    head1.next.next.next = new ListNode(7);

    // Limkedlist2
    ListNode head2 = new ListNode(2);
    a[1] = head2;
    head2.next = new ListNode(4);
    head2.next.next = new ListNode(6);
    head2.next.next.next = new ListNode(8);

    // Linkedlist3
    ListNode head3 = new ListNode(0);
    a[2] = head3;
    head3.next = new ListNode(9);
    head3.next.next = new ListNode(10);
    head3.next.next.next = new ListNode(11);

    ListNode res = mergeKLists(a);

    if (res != null)
      printList(res);
    System.out.println();
  }

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public ListNode mergeKLists(ListNode[] lists, int K) {
    // Priority_queue 'queue' implemented
    // as min heap with the help of
    // 'compare' function
    PriorityQueue<ListNode> queue
            = new PriorityQueue<>(new NodeComparator());
    ListNode head = new ListNode(0);
    ListNode last = head;
    // Push the head nodes of all
    // the k lists in 'queue'
    for (int i = 0; i < K; i++) {
      if (lists[i] != null) {
        queue.add(lists[i]);
      }
    }
    // Handles the case when k = 0
    // or lists have no elements in them
    if (queue.isEmpty())
      return null;
    // Loop till 'queue' is not empty
    while (!queue.isEmpty()) {
      // Get the top element of 'queue'
      ListNode curr = queue.poll();

      // Add the top element of 'queue'
      // to the resultant merged list
      last.next = curr;
      last = last.next;
      // Check if there is a node
      // next to the 'top' node
      // in the list of which 'top'
      // node is a member
      if (curr.next != null) {
        // Push the next node of top node
        // in 'queue'
        queue.add(curr.next);
      }
    }
    // Address of head node of the required
    // merged list
    return head.next;
  }
  public ListNode mergeKLists(ListNode[] lists) {
    return mergeKLists(lists, lists.length);
  }

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

  class NodeComparator implements Comparator<ListNode> {

    public int compare(ListNode k1, ListNode k2)
    {
      if (k1.val > k2.val)
        return 1;
      else if (k1.val < k2.val)
        return -1;
      return 0;
    }
  }
}
