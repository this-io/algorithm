package implementation.easy.tree;

public class MaximumDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
      return traverse(root);
  }

  public int traverse(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int l = traverse(node.left);
    int r = traverse(node.right);

    return Math.max(l, r) + 1;
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
