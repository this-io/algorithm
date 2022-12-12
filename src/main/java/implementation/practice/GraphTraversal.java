package implementation.practice;

import java.util.*;

public class GraphTraversal {
  class Node {
    public String val;
    public List<Node> edges;

    public Node(String val) {
      this.val = val;
      this.edges = new ArrayList<>();
    }

    public void connect(Node node) {
      this.edges.add(node);
      node.edges.add(this);
    }

    public List<Node> getAdjacentNodes() {
      return this.edges;
    }

    public boolean isConnected(Node node) {
      if (this.edges == null) {
        return false;
      }

      for (Node elementNode : this.edges) {
        if (elementNode.val.equals(node.val)) {
          return true;
        }
      }
      return false;
    }
  }

  class Graph {
    public List<Node> nodes = new ArrayList<>();

    public Graph(List<Node> nodes) {
      this.nodes.addAll(nodes);
    }

    public void addToGraph(Node node) {
      this.nodes.add(node);
    }
  }

  public static void main(String[] args) {
    GraphTraversal gt = new GraphTraversal();
    Graph theGraph = gt.buildGraph();
    Node startNode = theGraph.nodes.get(0);
    //Node endNode = theGraph.nodes.get(theGraph.nodes.size() - 1);
    Node endNode = theGraph.nodes.get(10);
    gt.dfs(startNode, endNode, new HashSet<>());
  }

  public void dfs(Node startNode, Node endNode, Set<String> visited) {
    if (visited == null) {
      visited = new HashSet<>();
    }
    if (visited.contains(startNode.val)) {
      return;
    }
    if (startNode.val == endNode.val) {
      System.out.println("Found " + startNode.val);
      return;
    }
    System.out.println("Visiting Node : " + startNode.val);
    visited.add(startNode.val);
    for (Node node : startNode.edges) {
      dfs(node, endNode, visited);

    }
  }

  public Graph buildGraph() {
    Node DFW = new Node("DFW");
    Node JFK = new Node("JFK");
    Node LAX = new Node("LAX");
    Node HNL = new Node("HNL");
    Node SAN = new Node("SAN");
    Node EWR = new Node("EWR");
    Node BOS = new Node("BOS");
    Node MIA = new Node("MIA");
    Node MCO = new Node("MCO");
    Node PBI = new Node("PBI");
    Node HKG = new Node("HKG");

    Graph ourGraph = new Graph(new ArrayList<Node>(
            Arrays.asList(DFW
                    , JFK
                    , LAX
                    , HNL
                    , SAN
                    , EWR
                    , BOS
                    , MIA
                    , MCO
                    , HKG
                    , PBI
            )
    ));

    DFW.connect(LAX);
    DFW.connect(JFK);
    LAX.connect(HNL);
    LAX.connect(EWR);
    LAX.connect(SAN);
    SAN.connect(HKG);
    JFK.connect(BOS);
    JFK.connect(MIA);
    MIA.connect(MCO);
    MIA.connect(PBI);
    MCO.connect(PBI);

    return ourGraph;
  }
}
