package implementation.easy.linkedl;

public class MergeTwoSortedLists {
  public static void main(String[] args) {
//    int[] first = {1, 2, 4};
//    int[] second = {1, 3, 4};
//    int[] first = {};
//    int[] second = {};
    int[] first = {-9, 3};
    int[] second = {5,7};
    ListNode root1 = arrayToList(first, first.length);
    ListNode root2 = arrayToList(second, second.length);
    MergeTwoSortedLists m = new MergeTwoSortedLists();
    ListNode resultRoot = m.mergeTwoLists(root1, root2);
    display(resultRoot);
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if(list1 == null && list2 == null) {
      return list1;
    }

    if(list1 == null) {
      return list2;
    }

    if(list2 == null) {
      return list1;
    }

    ListNode first = list1;
    ListNode second = list2;
    ListNode result = null;
    MergeTwoSortedLists r = new MergeTwoSortedLists();
    while(first != null || second != null) {
      if(second != null && first == null) {
        result = r.insert(result, second.val);
        second = second.next;
      }
      if(first != null && second == null) {
        result = r.insert(result, first.val);
        first = first.next;
      }
      if(first != null && second != null && first.val <= second.val) {
        result = r.insert(result, first.val);
        first = first.next;
      } else if(first != null && second != null && first.val > second.val){
        result = r.insert(result, second.val);
        second = second.next;
      }
    }
    return result;
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
    MergeTwoSortedLists r = new MergeTwoSortedLists();
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
