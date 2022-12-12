package implementation.medium.linkedl;

import implementation.easy.linkedl.MergeTwoSortedLists;
import org.jetbrains.annotations.NotNull;

public class RemoveNthNodeFromEndOfList {
  public static void main(String[] args) {
    //int[] input = {1,2,3,4,5};
    //int n = 2;
//    int[] input = {1};
//    int n = 1;
    int[] input = {1,2};
    int n = 1;
    ListNode root = arrayToList(input, input.length);
    display(root);
    System.out.println();
    System.out.println("============");
    //System.out.println();
    RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
    ListNode resultRootNode = r.removeNthFromEnd(root, n);
    display(resultRootNode);
  }

  public ListNode removeNthFromEnd(@NotNull ListNode head, int n) {
    if(n == 0) {
      return null;
    }
    ListNode zeroth = new ListNode(-1, head);
    ListNode left = zeroth;
    ListNode right = head;
    int counter = 0;
    while(n != counter) {
      right = right.next;
      //n -= 1;
      counter++;
    }

    while(right != null) {
      right = right.next;
      left = left.next;
    }

    left.next = left.next.next;
    return zeroth.next;
  }


  ListNode insert(ListNode root, int item) {
    ListNode temp = new ListNode();
    ListNode ptr;
    temp.val = item;
    temp.next = null;

    if (root == null) {
      root = temp;
    } else {
      ptr = root;
      while (ptr.next != null) {
        ptr = ptr.next;
      }
      ptr.next = temp;
    }
    return root;
  }

  static void display(ListNode root) {
    while (root != null) {
      System.out.print(root.val + " ");
      root = root.next;
    }
  }

  static ListNode arrayToList(int arr[], int n) {
    RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
    ListNode root = null;
    for (int i = 0; i < n; i++) {
      root = r.insert(root, arr[i]);
    }
    return root;
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
}
