package main.implementation.easy.binary;

public class CountingBits {
  public static void main(String[] args) {
    CountingBits c = new CountingBits();
    int[] result = c.countBits(5);
    for(int i : result) {
      System.out.print(i + "    ");
    }
  }

  public int[] countBits(int n) {
    int[] dp = new int[n + 1];

    int offset = 1;

    for (int i = 0; i < n + 1; i++) {
      if ((offset * 2) == i) {
        offset = i;
      }
      if (i == 0) {
        dp[i] = dp[i];
      } else {
        dp[i] = 1 + dp[i - offset];
      }

    }
    return dp;
  }
}
