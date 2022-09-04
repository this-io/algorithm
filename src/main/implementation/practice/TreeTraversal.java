package main.implementation.practice;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {
  class Node {
    public Node(char val) {
      this.val = val;
    }

    public char val;
    public Node left;
    public Node right;
  }

  public static void main(String[] args) {
    TreeTraversal treeTraversal = new TreeTraversal();
    Node root = treeTraversal.buildTree();
    System.out.println("This is root = " + root.val);
    dfs(root);
    bfs(root);
  }

  private Node buildTree() {
    Node a = new Node('a');
    Node b = new Node('b');
    Node c = new Node('c');
    Node d = new Node('d');
    Node e = new Node('e');
    Node f = new Node('f');

    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.right = f;

    return a;
  }

  public static void dfs(Node root) {
    Stack<Node> theDfsStack = new Stack();
    theDfsStack.push(root);
    while(!theDfsStack.isEmpty()) {
      Node currentNode = theDfsStack.pop();
      System.out.print("   "+ currentNode.val);

      if(currentNode.right != null) {
        theDfsStack.push(currentNode.right);
      }
      if(currentNode.left != null) {
        theDfsStack.push(currentNode.left);
      }
    }
  }

  public static void bfs(Node root) {
    System.out.println();
    Queue<Node> theBfsQueue = new ArrayDeque();
    theBfsQueue.add(root);

    while(!theBfsQueue.isEmpty()) {
      Node currentNode = theBfsQueue.remove();
      System.out.print("   "+ currentNode.val);
      if(currentNode.left != null) {
        theBfsQueue.add(currentNode.left);
      }
      if(currentNode.right != null) {
        theBfsQueue.add(currentNode.right);
      }
    }
  }
}
