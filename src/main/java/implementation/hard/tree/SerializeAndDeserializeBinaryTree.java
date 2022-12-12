package implementation.hard.tree;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
  public static void main(String[] args) {
    SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();

  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }

    List<String> result = new ArrayList<>();
    dfs(root, result);
    return String.join(",", result);
  }

  private void dfs(TreeNode node, List<String> result) {
    if (node == null) {
      result.add("N");
      return;
    }
    String s = "";

    result.add("" + node.val);
    dfs(node.left, result);
    dfs(node.right, result);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.isEmpty() || data.isBlank()) {
      return null;
    }

    String[] input = data.split(",");
    if (input[0] == "N") {
      return null;
    }
    //TreeNode root = new TreeNode(Integer.valueOf(input[0]));
    Counter counter = new Counter();
    return dfs(input, counter);
  }

  private TreeNode dfs(String[] arr, Counter counter) {
    if (arr[counter.getI()] == "N") {
      counter.increment();
      return null;
    }
    //TreeNode root;
    TreeNode theNode = new TreeNode(Integer.valueOf(arr[counter.getI()]));
    /*if(counter.getI() == 0) {
      root = theNode;
    }*/
    counter.increment();
    theNode.left = dfs(arr, counter);
    theNode.right = dfs(arr, counter);

    return theNode;
  }

  public class Counter {
    private int i = 0;

    public void increment() {
      i++;
    }
    public int getI() {
      return i;
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


}
