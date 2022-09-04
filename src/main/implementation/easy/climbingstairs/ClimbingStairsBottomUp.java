package main.implementation.easy.climbingstairs;

public class ClimbingStairsBottomUp {
  public static void main(String[] args) {
    ClimbingStairsBottomUp climbingStairsBottomUp = new ClimbingStairsBottomUp();
    int result = climbingStairsBottomUp.climbStairs(3);
    System.out.println(result);
  }

  public int climbStairs(int n) {
    if (n == 0) {
      return 0;
    }

    int[] stair = new int[n + 1];
    stair[1] = 1;
    stair[2] = 2;

    for (int i = 3; i <= n; i++) {
      stair[i] = stair[i - 1] + stair[i - 2];
    }
    return stair[n];
  }
}
