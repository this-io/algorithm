package main.implementation.medium.matrix;

public class RotateImage {
  public static void main(String[] args) {
    RotateImage ri = new RotateImage();
    int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
    displayMatrix(matrix);
    ri.rotate(matrix);
    System.out.println("======================");
    displayMatrix(matrix);
  }

  public void rotate(int[][] matrix) {
    if (matrix.length == 0) {
      return;
    }

    int left = 0, right = matrix.length - 1;

    while (left < right) {
      for (int i = 0; i < right - left; i++) {
        int top = left, bottom = right;

        int topLeft = matrix[top][left + i];

        matrix[top][left + i] = matrix[bottom - i][left];
        matrix[bottom - i][left] = matrix[bottom][right - i];
        matrix[bottom][right - i] = matrix[top + i][right];
        matrix[top + i][right] = topLeft;
      }
      right--;
      left++;
    }
  }

  private static void displayMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + "    ");
      }
      System.out.println();
    }
  }
}
