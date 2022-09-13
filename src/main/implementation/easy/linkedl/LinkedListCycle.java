package main.implementation.easy.linkedl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListCycle {
  class ListNode {
    int val;
    ListNode next;
    ListNode() {}

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public static void main(String[] args) {
    int[] input = {3,2,0,-4};

    ListNode root = arrayToList(input, input.length);
    LinkedListCycle l = new LinkedListCycle();

    ListNode t = root;
    ListNode toReiterate = null;
    ListNode tail = null;
    int counter = 0;
    int p =1;
    while(t != null) {
      if(t.next == null) {
        tail = t;
      }
      if(counter==p) {
        toReiterate = t;
      }
      t = t.next;
      counter++;
    }
    tail.next = toReiterate;
    System.out.println(l.hasCycle(root));
  }

  public boolean hasCycle(ListNode head) {
    if(head == null) {
      return false;
    }
    Set<ListNode> theSet = new HashSet<ListNode>();

    ListNode t = head;
    while(t != null) {
     if(theSet.contains(t)) {
       return true;
     }
     theSet.add(t);
     t = t.next;
    }
    return false;
  }



  // Function to insert node
  ListNode insert(ListNode root, int item) {
    ListNode temp = new ListNode();
    ListNode ptr;
    temp.val = item;
    temp.next = null;

    if (root == null)
      root = temp;
    else {
      ptr = root;
      while (ptr.next != null)
        ptr = ptr.next;
      ptr.next = temp;
    }
    return root;
  }

  static void display(ReverseLinkedList.ListNode root) {
    while (root != null) {
      System.out.print(root.val + " ");
      root = root.next;
    }
  }

  static ListNode arrayToList(int arr[], int n) {
    LinkedListCycle r = new LinkedListCycle();
    ListNode root = null;
    for (int i = 0; i < n; i++) {
      root = r.insert(root, arr[i]);
    }

    return root;
  }
}
