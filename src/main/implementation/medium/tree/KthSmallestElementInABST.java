package main.implementation.medium.tree;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestElementInABST {
  public static void main(String[] args) {

  }

  public int kthSmallest(TreeNode root, int k) {
    // Counter to keep track of the total number of the visited nodes.
    // `AtomicInteger` is used here since `Integer` is passed by value in Java
    AtomicInteger counter = new AtomicInteger(0);

    // Recursively find the k'th smallest node
    TreeNode  node = kthSmallest(root, counter, k);
    if(node == null) {
      return 0;
    }

    return node.val;
  }


  public static TreeNode kthSmallest(TreeNode root, AtomicInteger counter, int k)
  {
    // base case
    if (root == null) {
      return null;
    }

    // recur for the left subtree
    TreeNode left = kthSmallest(root.left, counter, k);

    // if k'th smallest node is found
    if (left != null) {
      return left;
    }

    // if the root is k'th smallest node
    if (counter.incrementAndGet() == k) {
      return root;
    }

    // recur for the right subtree only if k'th smallest node is not found
    // in the right subtree
    return kthSmallest(root.right, counter, k);
  }

}
