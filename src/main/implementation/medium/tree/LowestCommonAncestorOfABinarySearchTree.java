package main.implementation.medium.tree;

public class LowestCommonAncestorOfABinarySearchTree {
  public static void main(String[] args) {
    LowestCommonAncestorOfABinarySearchTree l = new LowestCommonAncestorOfABinarySearchTree();

  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode cur = root;

    while(cur != null) {
      if(p.val > cur.val && q.val > cur.val) {
        cur = cur.right;
      } else if(p.val < cur.val && q.val < cur.val) {
        cur = cur.left;
      } else {
        return cur;
      }
    }

    return null;
  }
}
