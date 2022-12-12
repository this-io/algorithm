package practice;

import java.util.HashMap;
import java.util.Map;

public class MergeMapFunc {
  public static void main(String args[]) {
    // create an HashMap
    Map<String, Integer> prices = new HashMap<>();

    // insert entries to the HashMap
    prices.put("Shoes", 200);
    prices.put("Bag", 300);
    prices.put("Pant", 150);
    System.out.println("HashMap: " + prices);

    int returnedValue = prices.merge("Shirt", 100, (oldValue, newValue) -> oldValue * newValue);
    System.out.println("Price of Shirt: " + returnedValue);

    returnedValue = prices.merge("Shirt", 100, (oldValue, newValue) -> oldValue * newValue);
    System.out.println("Price 2 of Shirt: " + returnedValue);
    // print updated HashMap
    System.out.println("Updated HashMap: " + prices);

    System.out.println(prices.hashCode());
  }
}
