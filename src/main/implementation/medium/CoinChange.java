package main.implementation.medium;

import java.util.Arrays;

public class CoinChange {
  public static void main(String[] args) {
    CoinChange coinChange = new CoinChange();
    //int[] input = { 2 };
    //int amount = 3;
    int[] input = {2, 5, 10, 1};
    int amount = 27;
    //int[] input = {186,419,83,408};
    //int amount = 6249;
    System.out.println(coinChange.coinChange(input, input.length, amount));
  }

  public int coinChange(int[] coins, int amount) {
    System.out.println("+++++");
    if(amount == 0) {
      return 1;
    }

    if(amount < 0) {
      return 0;
    }

    int result = 0;

    for(int i : coins) {
      result += coinChange(coins, amount - i);
    }

    return result;
  }

  public int coinChange(int coins[], int n, int sum) {
    // If sum is 0 then there is 1 solution
    // (do not include any coin)
    if (sum == 0)
      return 1;

    // If sum is less than 0 then no
    // solution exists
    if (sum < 0)
      return 0;

    // If there are no coins and sum
    // is greater than 0, then no
    // solution exist
    if (n <= 0)
      return 0;

    // count is sum of solutions (i)
    // including coins[n-1] (ii) excluding coins[n-1]
    return coinChange(coins, n - 1, sum)
            + coinChange(coins, n, sum - coins[n - 1]);
  }
}
