package implementation.medium;

import java.util.*;

public class CloneGraph {
  Map<Node, Node> oldNodeToNewNode = new HashMap<>();
  public static void main(String[] args) {
    CloneGraph cloneGraph = new CloneGraph();
    cloneGraph.cloneGraph(null);
  }

  public Node cloneGraph(Node node) {
    if(node == null) {
      return node;
    }

    dfs(node, null);

    if(oldNodeToNewNode == null || oldNodeToNewNode.isEmpty()) {
      return node;
    }

    for(Node oldNode : oldNodeToNewNode.keySet()) {
      Node newNode = oldNodeToNewNode.get(oldNode);
      newNode.neighbors = new ArrayList<>();
      for(Node oldNeighbour : oldNode.neighbors) {
        newNode.neighbors.add(oldNodeToNewNode.get(oldNeighbour));
      }
    }

    return oldNodeToNewNode.get(node);
  }

  private void dfs(Node node, Set<Integer> visited) {
    if(visited == null) {
      visited = new HashSet<>();
    }
    if(visited.contains(node.val)) {
      return;
    }

    visited.add(node.val);
    Node newNode = new Node(node.val);
    oldNodeToNewNode.put(node, newNode);

    for(Node neighbour: node.neighbors) {
      dfs(neighbour, visited);
    }
  }

  // Definition for a Node.
  class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
