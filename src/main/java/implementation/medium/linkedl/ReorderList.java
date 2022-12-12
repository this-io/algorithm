package implementation.medium.linkedl;

public class ReorderList {
  public static void main(String[] args) {
    //int[] input = {1, 2, 3, 4};
    int[] input = {1,2,3,4,5};
    ListNode head = arrayToList(input, input.length);
    display(head);
    System.out.println();
    System.out.println("=========");
    ReorderList r = new ReorderList();
    r.reorderList(head);
    display(head);
  }

  public void reorderList(ListNode head) {
    if (head != null && head.next != null) {
      ListNode slow = head;
      ListNode fast = head;

      while (fast != null && fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }

      ListNode second = slow.next;
      slow.next = null;
      second = reverseOrder(second);

      ListNode p1 = head;
      ListNode p2 = second;

      while (p2 != null) {
        ListNode temp1 = p1.next;
        ListNode temp2 = p2.next;

        p1.next = p2;
        p2.next = temp1;

        p1 = temp1;
        p2 = temp2;
      }
    }
  }

  public static ListNode reverseOrder(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    ListNode pre = head;
    ListNode curr = head.next;

    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = pre;
      pre = curr;
      curr = temp;
    }

    head.next = null;

    return pre;
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
    ReorderList r = new ReorderList();
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
