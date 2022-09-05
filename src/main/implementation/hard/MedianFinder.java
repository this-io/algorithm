package main.implementation.hard;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
  int counter;
  List<Integer> numbers;
  public static void main(String[] args) {
    String[] ops = {"MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"};
    int[][] input = {{}, {1}, {2}, {}, {3}, {}};

    MedianFinder medianFinder = null;
    double currentMedian = 0;
    for(int i=0; i<ops.length; i++) {
      if(ops[i].equalsIgnoreCase("MedianFinder")) {
        medianFinder = new MedianFinder();
      } else if(ops[i].equalsIgnoreCase("addNum")) {
        medianFinder.addNum(input[i][0]);
      } else if(ops[i].equalsIgnoreCase("findMedian")) {
        currentMedian = medianFinder.findMedian();
        System.out.println(currentMedian);
      } else {
        System.out.println("I ain't doing it..");
      }
    }
  }

  public MedianFinder() {
    counter = 0;
    numbers = new ArrayList<>();
  }

  public void addNum(int num) {

  }

  public double findMedian() {
    return 0;
  }
}
