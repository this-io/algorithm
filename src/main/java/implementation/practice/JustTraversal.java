package implementation.practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class JustTraversal {

  public static void main(String[] args) {
    int[][] input = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}, {3, 1, 2}};
    Set<String> visited = new HashSet<String>();
    JustTraversal j = new JustTraversal();
    Integer result = 0;
    PriorityQueue<Integer> theQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
    j.dfs(input, 0, 0, 0, theQueue, visited);

    System.out.println("RRRR : " + theQueue.peek());
  }

  public void dfs(int[][] input, int row, int col, int counter, PriorityQueue<Integer> result, Set<String> visited) {
    if (visited.contains(rowColToString(row, col))) {
      return;
    }

    visited.add(rowColToString(row, col));
    counter++;
    result.add(counter);

    System.out.println(rowColToString(row, col));
    System.out.println("Result :: " + result);
    if (row - 1 >= 0) {
      dfs(input, row - 1, col, counter, result, visited);
    }
    if (row + 1 < input.length) {
      dfs(input, row + 1, col, counter, result, visited);
    }
    if (col - 1 >= 0) {
      dfs(input, row, col - 1, counter, result, visited);
    }
    if (col + 1 < input[0].length) {
      dfs(input, row, col + 1, counter, result, visited);
    }
  }

  public static String rowColToString(int row, int col) {
    return row + "," + col;
  }
}