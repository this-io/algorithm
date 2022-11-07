package main.implementation.medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
    Integer[] arr = {3,9,20,null,null,15,7};
    TreeNode root = b.constructTree(arr);
    List<List<Integer>> resutl = b.levelOrder(root);

    for(List<Integer> r : resutl) {
      for (int t : r) {
        System.out.print(t + "\t");
      }
      System.out.println();
    }
  }

  private TreeNode constructTree(Integer[] arr) {
    Tree t = new Tree();
    t.construct(arr);
    return t.root;
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return null;
    }
    Queue<TreeNode> theBfsQueue = new LinkedList<>();
    theBfsQueue.add(root);
    List<List<Integer>> result = new ArrayList<>();

    int level = 1;
    while (!theBfsQueue.isEmpty()) {
      List<Integer> innerResult = new ArrayList<>();

      for (int i = 0; i < theBfsQueue.size(); i++) {
        TreeNode node = theBfsQueue.remove();

        if(node == null) {
          theBfsQueue.add(node.left);
          theBfsQueue.add(node.right);
          innerResult.add(node.val);
        }

      }
      result.add(innerResult);
      level *= 2;
    }

    return result;
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

    public TreeNode construct(Integer[] arr) {
      Tree t2 = new Tree();
      t2.root = t2.insertLevelOrder(arr, 0);
      //t2.inOrder(t2.root);

      return t2.root;
    }

    // Function to insert nodes in level order
    public TreeNode insertLevelOrder(Integer[] arr, int i) {
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
  }
}
