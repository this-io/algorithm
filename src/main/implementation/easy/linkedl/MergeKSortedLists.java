package main.implementation.easy.linkedl;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {
  public static void main(String[] args) {
    MergeKSortedLists m = new MergeKSortedLists();
    ListNode[] lists = new ListNode[3];
    int[] input = {1, 4, 5};
    lists[0] = arrayToList(input, input.length);
    int[] input1 = {1, 3, 4};
    lists[1] = arrayToList(input1, input1.length);
    int[] input2 = {2, 6};
    lists[2] = arrayToList(input2, input2.length);

    ListNode result = m.mergeKLists(lists);
    display(result);
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    int interval = 1;
    while (interval < lists.length) {
      for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
        lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
      }
      interval *= 2;
    }

    return lists[0];
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null && list2 == null) {
      return list1;
    }

    if (list1 == null) {
      return list2;
    }

    if (list2 == null) {
      return list1;
    }

    ListNode first = list1;
    ListNode second = list2;
    ListNode result = null;
    MergeKSortedLists r = new MergeKSortedLists();
    while (first != null || second != null) {
      if (second != null && first == null) {
        result = r.insert(result, second.val);
        second = second.next;
      }
      if (first != null && second == null) {
        result = r.insert(result, first.val);
        first = first.next;
      }
      if (first != null && second != null && first.val <= second.val) {
        result = r.insert(result, first.val);
        first = first.next;
      } else if (first != null && second != null && first.val > second.val) {
        result = r.insert(result, second.val);
        second = second.next;
      }
    }
    return result;
  }

  ListNode insert(ListNode root, int item) {
    ListNode temp = new ListNode(item, null);
    ListNode ptr;

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

  static ListNode arrayToList(int arr[], int n) {
    MergeKSortedLists r = new MergeKSortedLists();
    ListNode root = null;
    for (int i = 0; i < n; i++) {
      root = r.insert(root, arr[i]);
    }
    return root;
  }


  static void display(ListNode root) {
    while (root != null) {
      System.out.print(root.val + " ");
      root = root.next;
    }
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
