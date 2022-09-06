package main.implementation.medium.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
  int rows = 0, cols = 0;
  Queue<Pair> theQ = new LinkedList<>();

  public static void main(String[] args) {
//    char[][] grid = {
//            {'1', '1', '1', '1', '0'},
//            {'1', '1', '0', '1', '0'},
//            {'1', '1', '0', '0', '0'},
//            {'0', '0', '0', '0', '0'}
//    };
    char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };
    NumberOfIslands n = new NumberOfIslands();
    System.out.println(n.numIslands(grid));
  }

  public int numIslands(char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    rows = grid.length;
    cols = grid[0].length;
    int islands = 0;
    boolean[][] visited = new boolean[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          bfs(grid, visited, i, j);
          islands++;
        }
      }
    }
    return islands;
  }

  private void bfs(char[][] grid, boolean[][] visited, int r, int c) {
    theQ.add(new Pair(r, c));
    visited[r][c] = true;

    while (!theQ.isEmpty()) {
      int i = theQ.peek().first;
      int j = theQ.peek().second;

      theQ.remove();

      if (isSafe(grid, i - 1, j, visited)) {
        visited[i - 1][j] = true;
        bfs(grid, visited, i - 1, j);
      }
      if (isSafe(grid, i + 1, j, visited)) {
        visited[i + 1][j] = true;
        bfs(grid, visited, i + 1, j);
      }
      if (isSafe(grid, i, j - 1, visited)) {
        visited[i][j - 1] = true;
        bfs(grid, visited, i, j - 1);
      }
      if (isSafe(grid, i, j + 1, visited)) {
        visited[i][j + 1] = true;
        bfs(grid, visited, i, j + 1);
      }
    }
  }

  private boolean isSafe(char[][] grid, int i, int j, boolean vis[][]) {
    return (i >= 0) && (i < rows) &&
            (j >= 0) && (j < cols) &&
            (grid[i][j] == '1' && !vis[i][j]);
  }

  static class Pair {
    int first, second;

    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
}
