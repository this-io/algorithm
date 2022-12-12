package implementation.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindLeavesOfBinaryTree_DidNotUnderstand {
  Stack<TreeNode> theStack = new Stack<>();
  public static void main(String[] args) {
    FindLeavesOfBinaryTree_DidNotUnderstand f = new FindLeavesOfBinaryTree_DidNotUnderstand();
    f.findLeaves(null);
  }

  public List<List<Integer>> findLeaves(TreeNode root) {
    TreeNode root1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);

    root1.left = node2;
    root1.right = node3;
    node2.left = node4;
    node2.right = node5;

    List<List<Integer>> result = new ArrayList<>();

    dfs(root1, result);
    return result;
  }

  private Integer dfs(TreeNode node, List<List<Integer>> result) {
    if(node == null) {
      return -1;
    }

    int level = Math.max(dfs(node.left, result), dfs(node.right, result)) + 1;

    if(result.size() <= level) {
      result.add(new ArrayList<>());
    }

    result.get(level).add(node.val);
    System.out.println(level);
    return level;
//    if(node.left == null && node.right == null) {
//      List<Integer> innerResult = new ArrayList<>();
//      innerResult.add(node.val);
//    }
//
//    dfs(node.left, result);
//    System.out.println(node.val);
//    dfs(node.right, result);
//
//    return -1;
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
