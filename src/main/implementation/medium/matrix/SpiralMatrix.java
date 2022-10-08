package main.implementation.medium.matrix;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpiralMatrix {
  public static void main(String[] args) {
    int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    SpiralMatrix sm = new SpiralMatrix();
    //List<Integer> output = sm.spiralOrder(input);
    for(int i : sm.spiralOrder(input)) {
      System.out.print(i+" -> ");
    }
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix.length == 0) {
      return new ArrayList<>();
    }

    int left = 0, right = matrix[0].length, top = 0, bottom = matrix.length;
    List<Integer> output = new ArrayList<>();

    while (left < right && top < bottom) {
      for (int i = left; i < right; i++) {
          output.add(matrix[top][i]);
      }
      top++;

      for (int i = top; i < bottom; i++) {
          output.add(matrix[i][right - 1]);
      }
      right--;

      if(!(left < right && top < bottom)) {
        break;
      }

      for (int i = right - 1; i >= left; --i) {
          output.add(matrix[bottom - 1][i]);
      }
      bottom--;

      for(int i=bottom - 1; i >= top; --i) {
          output.add(matrix[i][left]);
      }
      left++;
    }

    return output;
  }
}
