package main.implementation.easy.tree;

public class InvertBinaryTree {

  public static void main(String[] args) {
    InvertBinaryTree i = new InvertBinaryTree();
    int[] arr = {4, 2, 7, 1, 3, 6, 9};
    //TreeNode root2 = i.invertTree(i.construct(arr));
    //System.out.println(root2.val);
    printInOrder(i.construct(arr));
  }

  public TreeNode construct(int[] arr) {
    return new Tree().construct(arr);
  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    theInvertTree(root);
    return root;
  }

  public void theInvertTree(TreeNode node) {
    if (node == null) {
      return;
    }

    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;

    invertTree(node.left);
    invertTree(node.right);
  }

  private static void printInOrder(TreeNode node) {
    if (node == null) {
      return;
    }
    System.out.printf("%s ", node.val);
    printInOrder(node.left);
    printInOrder(node.right);
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

  public class Tree {
    TreeNode root;

    public TreeNode construct(int[] arr) {
      Tree t2 = new Tree();
      t2.root = t2.insertLevelOrder(arr, 0);
      //t2.inOrder(t2.root);

      return t2.root;
    }

    // Function to insert nodes in level order
    public TreeNode insertLevelOrder(int[] arr, int i) {
      TreeNode root = null;
      // Base case for recursion
      if (i < arr.length) {
        root = new TreeNode(arr[i]);
        // insert left child
        root.left = insertLevelOrder(arr, 2 * i + 1);
        // insert right child
        root.right = insertLevelOrder(arr, 2 * i + 2);
      }
      return root;
    }

//    // Function to print tree nodes in InOrder fashion
//    public void inOrder(TreeNode root) {
//      if (root != null) {
//        return;
//      }
//      inOrder(root.left);
//      inOrder(root.right);
//    }
  }
}