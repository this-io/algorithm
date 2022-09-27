package main.implementation.medium.matrix;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
  public static void main(String[] args) {
    //int[][] input = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    int[][] input = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    displayMatrix(input);
    SetMatrixZeroes s = new SetMatrixZeroes();
    s.setZeroes(input);
  }

  public void setZeroes(@NotNull int[][] matrix) {
    Set<Integer> setRowsToZero = new HashSet<>();
    Set<Integer> setColToZero = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          setRowsToZero.add(i);
          setColToZero.add(j);
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      if (setRowsToZero.contains(i)) {
        for (int j = 0; j < matrix[i].length; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < matrix[0].length; i++) {
      if (setColToZero.contains(i)) {
        for (int j = 0; j < matrix.length; j++) {
          matrix[j][i] = 0;
        }
      }
    }

    System.out.println();
    System.out.println("===========================");
    displayMatrix(matrix);
  }

  private static void displayMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + "    ");
      }
      System.out.println();
    }
  }
}
