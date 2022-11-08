package main.implementation.medium.tree;

public class ValidateBinarySearchTree {
  public static void main(String[] args) {
    ValidateBinarySearchTree v = new ValidateBinarySearchTree();
    v.isValidBST(null);
  }

  public boolean isValidBST(TreeNode root) {
    if(root == null) {
      return false;
    }

    return valid(root, (Double.POSITIVE_INFINITY * -1), Double.POSITIVE_INFINITY);
  }

  private boolean valid(TreeNode node, double left, double right) {
    if(node == null) {
      return true;
    }

    if(!(node.val < right && node.val > left)) {
      return false;
    }

    return (valid(node.left, left, node.val)  && valid(node.right, node.val, right));
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
