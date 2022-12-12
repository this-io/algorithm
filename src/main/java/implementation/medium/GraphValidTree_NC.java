package implementation.medium;

import java.util.*;

public class GraphValidTree_NC {
  public static void main(String[] args) {
    GraphValidTree_NC graphValidTree = new GraphValidTree_NC();
    int[][] input = {{0,1},{1,2},{2,3},{1,3},{1,4}};
    int n = 5;

    System.out.println(graphValidTree.validTree(n, input));
  }

  public boolean validTree(int n, int[][] edges) {
    //List<List<Integer>> adjList = new ArrayList<>();
    Map<Integer, List<Integer>> adjList= new HashMap<>();
    for(int[] i : edges) {
      if(adjList.containsKey(i[0])) {
        List<Integer> temp = adjList.get(i[0]);
        temp.add(i[1]);
        adjList.put(i[0], temp);
      } else {
        List<Integer> temp = new ArrayList<>();
        temp.add(i[1]);
        adjList.put(i[0], temp);
        //adjList.put(i[0], new ArrayList<>());
      }
      if(adjList.containsKey(i[1])) {
        List<Integer> temp = adjList.get(i[1]);
        temp.add(i[0]);
        adjList.put(i[1], temp);
      } else {
        List<Integer> temp = new ArrayList<>();
        temp.add(i[0]);
        adjList.put(i[1], temp);
      }
    }

    for(int i : adjList.keySet()) {
      System.out.print(i+ " : ");
      for(int j : adjList.get(i)) {
        System.out.print(j + "   ");
      }
      System.out.println();
    }

    Map<Integer, Integer> k = new HashMap<>();
    k.put(0, -1);
    Stack<Integer> theStack = new Stack<>();
    theStack.push(0);

    while(!theStack.isEmpty()) {
      int thePopped = theStack.pop();

      for(Integer temp : adjList.get(thePopped)) {
        if(k.get(thePopped) != temp) {
          if(k.containsKey(temp)) {
            return false;
          }
          theStack.push(temp);
          k.put(temp, thePopped);
        }
      }
    }

    return n == k.size();
  }
}
