package main.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {
  public static void main(String[] args) {
    TimeNeededToInformAllEmployees t = new TimeNeededToInformAllEmployees();
//    int n = 6;
//    int headID = 2;
//    int[] manager = {2, 2, -1, 2, 2, 2};
//    int[] informTime = {0, 0, 1, 0, 0, 0};
//    int n = 1;
//    int headID = 0;
//    int[] manager = {-1};
//    int[] informTime = {0};
    int n = 15;
    int headID = 0;
    int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
    int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
    System.out.println(t.numOfMinutes(n, headID, manager, informTime));
  }

  public int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {

    Node head = constructTree(n, headId, manager, informTime);
    int time = 0;
    return dfs(head, 0);
//    System.out.println(time);
//    return time;
  }

  private int dfs(Node node, int time) {
    if (node == null) {
      return time;
    }
    int maxTT = time;
    for (Node j : node.children) {
      maxTT = Math.max(dfs(j, time + node.informTime), maxTT);
    }
    return maxTT;
  }

  private Node constructTree(int n, int headId, int[] manager, int[] informTime) {
    Map<Integer, Node> theMap = new HashMap<>();
    Node head = new Node(headId, informTime[headId]);
    theMap.put(headId, head);
    for (int i = 0; i < n; i++) {
      if (i != headId) {
        theMap.put(i, new Node(i, informTime[i]));
      }
    }

    for (int i = 0; i < manager.length; i++) {
      if (manager[i] != -1) {
        theMap.get(manager[i]).children.add(theMap.get(i));
      }
    }

//    for(Integer i : theMap.keySet()) {
//      System.out.print(i + " = ");
//      for(Node k : theMap.get(i).children) {
//        System.out.print(k.index + "  ");
//      }
//      System.out.println();
//    }
    return head;
  }

  class Node {
    int index;
    int informTime;
    List<Node> children = new ArrayList<>();

    public Node(int index, int informTime) {
      this.index = index;
      this.informTime = informTime;
    }
  }

}
