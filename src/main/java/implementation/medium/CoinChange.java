package implementation.medium;
import java.util.Arrays;

public class CoinChange {
  public static void main(String[] args) {
    CoinChange coinChange = new CoinChange();
//    int[] input = {1,2,5};
//    int amount = 11;
    int[] input = {1};
    int amount = 0;
    System.out.println(coinChange.coinChangeAlgo(input, amount));
  }

  /**
   * @description Algorithm computes the minimum number of coins needed to sum up to the amount. If
   * it is not possible to get the amount returns -1. Takes the bottom up approach dynamic programming
   * approach.
   * @param coins
   * @param amount
   * */
  public int coinChangeAlgo(int[] coins, int amount) {
    if(amount == 0) {
      return 0;
    }
    if(coins.length == 0) {
      return -1;
    }
    Arrays.sort(coins);
    int minInArray = coins[0];
    if(amount < minInArray) {
      return -1;
    }
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for(int i = 1; i <= amount; i++) {
      for(int coin : coins) {
        if(i - coin >= 0) {
          dp[i] = Math.min(dp[i], 1+dp[i-coin]);
        }
      }
    }
    if(dp[amount] != amount + 1) {
      return dp[amount];
    }
    return -1;
  }
}
