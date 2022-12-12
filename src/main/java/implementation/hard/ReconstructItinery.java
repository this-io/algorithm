package implementation.hard;

import implementation.practice.GraphTraversal;

import java.util.*;

public class ReconstructItinery {

  int n = 0;

  public static void main(String[] args) {
    ReconstructItinery reconstructItinery = new ReconstructItinery();
    List<List<String>> input = new ArrayList<>();

    input.add(new ArrayList<String>() {{
      add("JFK");
      add("KUL");
    }});
    input.add(new ArrayList<String>() {{
      add("JFK");
      add("NRT");
    }});
    input.add(new ArrayList<String>() {{
      add("NRT");
      add("JFK");
    }});
    /*input.add(new ArrayList<String>() {{
      add("MUC");
      add("LHR");
    }});
    input.add(new ArrayList<String>() {{
      add("JFK");
      add("MUC");
    }});
    input.add(new ArrayList<String>() {{
      add("SFO");
      add("SJC");
    }});
    input.add(new ArrayList<String>() {{
      add("LHR");
      add("SFO");
    }});*/

    /*input.add(new ArrayList<String>() {{
      add("JFK");
      add("SFO");
    }});
    input.add(new ArrayList<String>() {{
      add("JFK");
      add("ATL");
    }});
    input.add(new ArrayList<String>() {{
      add("SFO");
      add("ATL");
    }});
    input.add(new ArrayList<String>() {{
      add("ATL");
      add("JFK");
    }});
    input.add(new ArrayList<String>() {{
      add("ATL");
      add("SFO");
    }});*/

    reconstructItinery.findItinerary(input);

  }

  public List<String> findItinerary(List<List<String>> tickets) {

    List<String> rst = new LinkedList<>();
    Set<String> citySet = new HashSet<>();
    Map<String, List<String>> map = buildMap(tickets);
    n = tickets.size();
    rst.add("JFK");
    dfs(rst, map, "JFK");
    return rst;
  }

  private boolean dfs(List<String> list, Map<String, List<String>> map, String curr) {
    if (list.size() == n + 1) return true;
    if (!map.containsKey(curr)) return false;
    List<String> destinations = map.get(curr);
    for (int i = 0; i < destinations.size(); i++) {
      String next = destinations.get(i);
      destinations.remove(i);
      list.add(next);

      if (dfs(list, map, next)) return true;

      // backtrack
      destinations.add(i, next);
      list.remove(list.size() - 1);
    }
    return false;
  }

  private Map<String, List<String>> buildMap(List<List<String>> tickets) {
    Map<String, List<String>> map = new HashMap<>();
    for (List<String> ticket : tickets) {
      map.putIfAbsent(ticket.get(0), new LinkedList<>());
      map.get(ticket.get(0)).add(ticket.get(1));
    }
    for (String key : map.keySet()){
      Collections.sort(map.get(key));
    }
    return map;
  }


  /*private Map<String, Node> airportToNode = new HashMap<>();
  private Graph theGraph;

  public static void main(String[] args) {
    ReconstructItinery reconstructItinery = new ReconstructItinery();
    List<List<String>> input = new ArrayList<>();

    input.add(new ArrayList<String>() {{
      add("JFK");
      add("KUL");
    }});
    input.add(new ArrayList<String>() {{
      add("JFK");
      add("NRT");
    }});
    input.add(new ArrayList<String>() {{
      add("NRT");
      add("JFK");
    }});
    /*input.add(new ArrayList<String>() {{
      add("MUC");
      add("LHR");
    }});
    input.add(new ArrayList<String>() {{
      add("JFK");
      add("MUC");
    }});
    input.add(new ArrayList<String>() {{
      add("SFO");
      add("SJC");
    }});
    input.add(new ArrayList<String>() {{
      add("LHR");
      add("SFO");
    }});*/

    /*input.add(new ArrayList<String>() {{
      add("JFK");
      add("SFO");
    }});
    input.add(new ArrayList<String>() {{
      add("JFK");
      add("ATL");
    }});
    input.add(new ArrayList<String>() {{
      add("SFO");
      add("ATL");
    }});
    input.add(new ArrayList<String>() {{
      add("ATL");
      add("JFK");
    }});
    input.add(new ArrayList<String>() {{
      add("ATL");
      add("SFO");
    }});

    reconstructItinery.findItinerary(input);

  }*/

  /*public List<String> findItinerary(List<List<String>> tickets) {
    if (tickets == null || tickets.isEmpty()) {
      return new ArrayList<>();
    }

    Node startNode = buildGraph(tickets);
    //System.out.println("This is start ::: " + startNode.val);
    //System.out.println("This si :: "+ airportToNode.get("ATL").edges.size());
    List<Node> result = new ArrayList<>();
    dfs(startNode, result);
    List<String> theResult = new ArrayList<>();
    for (Node looper : result) {
      System.out.print(looper.val+ "->");
      theResult.add(looper.val);
    }
    return theResult;
  }

  public void dfs(Node node, List<Node> result) {
    result.add(node);
    if(node.edges.isEmpty()) {
      return;
    }
    for(int i=0; i<node.edges.size(); i++) {
      String val = node.edges.get(0);
      node.edges.remove(val);
      dfs(airportToNode.get(val), result);
    }
  }

  private Node buildGraph(List<List<String>> tickets) {
    theGraph = new Graph();
    Node startNode = null;
    for (List<String> ticket : tickets) {
      Node start;
      Node destination;
      if (airportToNode.containsKey(ticket.get(0))) {
        start = airportToNode.get(ticket.get(0));
      } else {
        start = new Node(ticket.get(0));
        airportToNode.put(ticket.get(0), start);
      }

      if (airportToNode.containsKey(ticket.get(1))) {
        destination = airportToNode.get(ticket.get(1));
      } else {
        destination = new Node(ticket.get(1));
        airportToNode.put(ticket.get(1), destination);
      }

      if (ticket.get(0).equalsIgnoreCase("JFK")) {
        startNode = start;
      }
      if (ticket.get(1).equalsIgnoreCase("JFK")) {
        startNode = destination;
      }
      start.connect(destination);

      theGraph.addToGraph(start);
      theGraph.addToGraph(destination);
      Collections.sort(start.edges);
    }

    return startNode;
  }

  class Node {
    public String val;
    public List<String> edges = new ArrayList<>();

    public Node(String val) {
      this.val = val;
    }

    public void connect(Node node) {
      edges.add(node.val);
    }
  }

  class Graph {
    List<Node> nodes = new ArrayList<>();

    public Graph() {
    }

    public Graph(List<Node> nodes) {
      this.nodes.addAll(nodes);
    }

    public void addToGraph(Node node) {
      this.nodes.add(node);
    }
  }*/
}
