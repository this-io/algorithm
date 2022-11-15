package main.implementation.medium;

import java.util.*;

public class StockPrice {
  /*int current = 0;
  PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
  PriorityQueue<Integer> minQueue = new PriorityQueue<>();
  int min = Integer.MAX_VALUE;
  Map<Integer, Integer> stampToStockValue = new HashMap<>();
  int maxTimeStamp = 0;

  public static void main(String[] args) {
    StockPrice s = new StockPrice();
    //String[] command = {"StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"};
    //int[][] stockVal = {{}, {1, 10}, {2, 5}, {}, {}, {1, 3}, {}, {4, 2}, {}};
    //String[] command = {"StockPrice", "update", "maximum", "current", "minimum", "maximum", "maximum", "maximum", "minimum", "minimum", "maximum", "update", "maximum", "minimum", "update", "maximum", "minimum", "current", "maximum", "update", "minimum", "maximum", "update", "maximum", "maximum", "current", "update", "current", "minimum", "update", "update", "minimum", "minimum", "update", "current", "update", "maximum", "update", "minimum"};
    //int[][] stockVal = {{}, {38, 2308}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {47, 7876}, {}, {}, {58, 1866}, {}, {}, {}, {}, {43, 121}, {}, {}, {40, 5339}, {}, {}, {}, {32, 5339}, {}, {}, {43, 6414}, {49, 9369}, {}, {}, {36, 3192}, {}, {48, 1006}, {}, {53, 8013}, {}};
    String[] command = {"StockPrice","update","maximum","current","maximum","current","minimum","update","maximum","maximum","current","maximum","current","current","maximum","current","update","minimum","current","minimum","maximum","current","update","update","maximum","update","update","minimum","maximum","minimum","update","minimum","current","maximum","current","current","update","current","maximum","update","maximum","current","maximum","minimum","minimum"};
    int[][] stockVal = {{},{88,9184},{},{},{},{},{},{83,343},{},{},{},{},{},{},{},{},{87,693},{},{},{},{},{},{88,7810},{89,624},{},{86,9963},{88,7345},{},{},{},{83,5533},{},{},{},{},{},{85,4908},{},{},{85,5125},{},{},{},{},{}};
    s.startProcess(command, stockVal);
    //s.justSideToSide();
  }

  public void startProcess(String[] command, int[][] stockVal) {
    StockPrice s = new StockPrice();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < command.length; i++) {
      if (command[i].equalsIgnoreCase("StockPrice")) {
        result.add(null);
      } else if (command[i].equalsIgnoreCase("update")) {
        s.update(stockVal[i][0], stockVal[i][1]);
        result.add(null);
      } else if (command[i].equalsIgnoreCase("current")) {
        result.add(s.current());
      } else if (command[i].equalsIgnoreCase("maximum")) {
        result.add(s.maximum());
      } else {
        result.add(s.minimum());
      }
    }
    //Integer[] expected = {null, null, 2308, 2308, 2308, 2308, 2308, 2308, 2308, 2308, 2308, null, 7876, 2308, null, 7876, 1866, 1866, 7876, null, 121, 7876, null, 7876, 7876, 1866, null, 1866, 121, null, null, 1866, 1866, null, 1866, null, 9369, null, 1006};
    Integer[] expected = {null,null,9184,9184,9184,9184,9184,null,9184,9184,9184,9184,9184,9184,9184,9184,null,343,9184,343,9184,9184,null,null,7810,null,null,343,9963,343,null,624,624,9963,624,624,null,624,9963,null,9963,624,9963,624,624};
    int counter = 0;
    for (Integer i : result) {
      System.out.print(counter + "  " + command[counter] +"   "+ i + "  " + expected[counter] + "       ");
      for(Integer a : stockVal[counter]) {
        System.out.print(a + "  ");
      }
      System.out.println();
      counter++;
    }
  }

  public void update(int timestamp, int price) {
    if (stampToStockValue.containsKey(timestamp)) {
      int currentMax = maxQueue.peek();
      int currentTimeStampPrice = stampToStockValue.get(timestamp);
      if(currentMax == currentTimeStampPrice) {
        maxQueue.remove();
      }
      maxQueue.add(price);

      int currentMin = minQueue.peek();
      if(currentMin == currentTimeStampPrice) {
        minQueue.remove();
      }
      minQueue.add(price);

    } else {
      maxQueue.add(price);
      minQueue.add(price);
      maxTimeStamp = Math.max(maxTimeStamp, timestamp);
    }
    System.out.println(timestamp + "  "+ price);
    System.out.println("Max : "+ maxQueue.peek());
    System.out.println("Min : "+ minQueue.peek());
    stampToStockValue.put(timestamp, price);
  }

  public int current() {
    return stampToStockValue.get(maxTimeStamp);
  }

  public int maximum() {
    return maxQueue.peek();
  }

  public int minimum() {
    return minQueue.peek();
  }*/

  HashMap<Integer, Integer> map;
  Stock current;
  PriorityQueue<Stock> maxHeap;
  PriorityQueue<Stock> minHeap;
  public StockPrice() {
    map = new HashMap<>();
    current = new Stock();
    maxHeap = new PriorityQueue<>((o1,o2) -> (o2.price - o1.price));
    minHeap = new PriorityQueue<>((o1,o2) -> (o1.price - o2.price));
  }

  public void update(int timestamp, int price) {
    Stock stock = new Stock(timestamp,price);
    if(timestamp >= current.timestamp){
      current = stock;
    }
    maxHeap.add(stock);
    minHeap.add(stock);
    map.put(timestamp,price);
  }

  public int current() {
    return current.price;
  }

  public int maximum() {
    while(maxHeap.peek().price != map.get(maxHeap.peek().timestamp)){
      maxHeap.poll();//remove outdated data
    }
    return maxHeap.peek().price;
  }

  public int minimum() {
    while(minHeap.peek().price != map.get(minHeap.peek().timestamp)){
      minHeap.poll();//remove outdated data
    }
    return minHeap.peek().price;
  }

  class Stock{
    int price;
    int timestamp;
    public Stock(){}
    public Stock(int timestamp, int price){
      this.timestamp = timestamp;
      this.price = price;
    }
  }
}
