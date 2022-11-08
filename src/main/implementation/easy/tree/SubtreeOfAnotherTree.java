package main.implementation.easy.tree;

import java.util.Stack;

public class SubtreeOfAnotherTree {
  Stack<TreeNode> theStack = new Stack();
  Stack<TreeNode> theSubStack = new Stack();

  public static void main(String[] args) {
    SubtreeOfAnotherTree t = new SubtreeOfAnotherTree();

  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if(subRoot == null) {
      return true;
    }
    if(root == null) {
      return false;
    }

    if(isSameTree(root, subRoot)) {
      return true;
    }

    return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if(p != null && q != null && p.val == q.val) {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    return false;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
