package main.implementation.easy.linkedl;
import java.util.Stack;

public class ReverseLinkedList {
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
    ReverseLinkedList r = new ReverseLinkedList();
    int[] input = {1, 2, 3, 4, 5};

    ListNode root = arrayToList(input, input.length);
    r.reverseList(root);
  }

  public ListNode reverseList(ListNode head) {
    if(head == null) {
      return head;
    }
    Stack<Integer> theStack = new Stack<>();
    while (head != null) {
      System.out.println(head.val);
      theStack.add(head.val);
      head = head.next;
    }
    ListNode newHead = new ListNode();
    newHead.val = theStack.pop();
    newHead.next = null;

    ListNode temp = newHead;
    while(!theStack.isEmpty()) {
       ListNode newNode = new ListNode();
       newNode.val = theStack.pop();
       temp.next =newNode;
       temp = newNode;
    }

    System.out.println("=====Answer======");
    //display(newHead);

    return newHead;
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

  static void display(ListNode root) {
    while (root != null) {
      System.out.print(root.val + " ");
      root = root.next;
    }
  }

  static ListNode arrayToList(int arr[], int n) {
    ReverseLinkedList r = new ReverseLinkedList();
    ListNode root = null;
    for (int i = 0; i < n; i++)
      root = r.insert(root, arr[i]);
    return root;
  }
}
