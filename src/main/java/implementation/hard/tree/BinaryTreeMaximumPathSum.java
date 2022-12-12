package implementation.hard.tree;

import implementation.easy.tree.InvertBinaryTree;

public class BinaryTreeMaximumPathSum {
  public static void main(String[] args) {
    BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
    Integer[] arr = {-10,9,20,null,null,15,7};
    System.out.println();
  }

  int result = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    dfs(root);
    return result;
  }

  private int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftMax = dfs(node.left);
    int rightMax = dfs(node.right);

    leftMax = Math.max(leftMax, 0);
    rightMax = Math.max(rightMax, 0);

    result = Math.max(result, node.val + leftMax + rightMax);

    return node.val + Math.max(leftMax, rightMax);
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
