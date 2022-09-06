package main.implementation.easy.array;

public class BestTimeToBuyAndSellStock {
  public static void main(String[] args) {
    BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
    int[] input = {7, 1, 5, 3, 6, 4};
    //int[] input = {1,2,4,2,5,7,2,4,9,0,9};
    System.out.println(bestTimeToBuyAndSellStock.maxProfit(input));
  }

  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }

    int left = 0;
    int right = 1;
    int max = 0;
    while(right < prices.length) {
      if(prices[left] < prices[right]) {
        int profit = prices[right] - prices[left];
        max = Math.max(profit, max);
      } else {
        left = right;
      }
      right += 1;
    }

    return max;
  }
}
