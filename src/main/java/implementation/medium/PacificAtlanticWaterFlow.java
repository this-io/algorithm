package implementation.medium;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
  public static void main(String[] args) {
    PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
    int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
    pacificAtlanticWaterFlow.pacificAtlantic(heights);
  }

  //Start dfs from top row
  //Start dfs from bottom row
  //start dfs from left col
  //Start dfs from right col

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> res = new ArrayList<>();
    if (heights == null || heights.length == 0 || heights[0].length == 0) {
      return res;
    }

    int row = heights.length;
    int col = heights[0].length;
    boolean[][] pacific = new boolean[row][col];
    boolean[][] atlantic = new boolean[row][col];

    for(int i=0; i<col; i++) {
      dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
      dfs(heights, row-1, i, Integer.MIN_VALUE, atlantic);
    }

    for(int i=0; i<row; i++) {
      dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
      dfs(heights, i, col-1, Integer.MIN_VALUE, atlantic);
    }

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          res.add(Arrays.asList(i, j));
        }
      }
    }

    for(List<Integer> i : res) {
      for(Integer j : i) {
        System.out.print(j + "   ");
      }
      System.out.println();
    }
    return res;
  }

  private void dfs(int[][] m, int r, int c, int prev, boolean[][] o) {
    if (r < 0 || r >= o.length || c < 0 || c >= o[0].length || m[r][c] < prev || o[r][c]) {
      return;
    }

    o[r][c] = true;

    dfs(m, r+1, c, m[r][c], o);
    dfs(m, r-1, c, m[r][c], o);
    dfs(m, r, c+1, m[r][c], o);
    dfs(m, r, c-1, m[r][c], o);
  }
}
