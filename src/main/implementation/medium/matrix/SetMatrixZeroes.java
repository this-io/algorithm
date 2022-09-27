package main.implementation.medium.matrix;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class SetMatrixZeroes {
  public static void main(String[] args) {
    int[][] input = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    SetMatrixZeroes s = new SetMatrixZeroes();
    s.setZeroes(input);
  }

  public void setZeroes(@NotNull int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if(matrix[i][j] == 0) {

        }
      }
    }
  }

  public void dfs(int[][] matrix, Set<Integer> visited) {

  }
}
