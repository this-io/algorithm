package main.implementation.easy.climbingstairs;

public class ClimbingStairs {
  public static void main(String[] args) {
    ClimbingStairs climbingStairs = new ClimbingStairs();
    climbingStairs.climbStairs(3);
  }

  public int climbStairs(int n) {
    int result = climbStairs(0, n);
    System.out.println(result);
    return result;
  }

  private int climbStairs(int i, int n) {
    if (i > n) {
      return 0;
    }

    if (i == n) {
      return 1;
    }

    return climbStairs(i + 1, n) + climbStairs(i + 2, n);
  }
}
