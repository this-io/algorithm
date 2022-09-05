package main.implementation.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianFinder {
  int counter;
  static List<Double> numbers;
  static List<Double> result;

  public static void main(String[] args) {
//    MedianFinder medianFinderStart = new MedianFinder(0);
//    medianFinderStart.startProcess();

    String[] ops = {"MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"};
    int[][] input = {{},{6},{},{10},{},{2},{},{6},{},{5},{},{0},{},{6},{},{3},{},{1},{},{0},{},{0},{}};

    MedianFinder medianFinder = null;
    double currentMedian = 0;
    for (int i = 0; i < ops.length; i++) {
      if (ops[i].equalsIgnoreCase("MedianFinder")) {
        medianFinder = new MedianFinder();
        result.add(null);
      } else if (ops[i].equalsIgnoreCase("addNum")) {
        medianFinder.addNum(input[i][0]);
        result.add(null);
      } else if (ops[i].equalsIgnoreCase("findMedian")) {
        currentMedian = medianFinder.findMedian();
        //System.out.println(currentMedian);
        result.add(currentMedian);
      } else {
        System.out.println("I ain't doing it..");
      }
    }
    Double[] expected = {null,null,6.00000,null,8.00000,null,6.00000,null,6.00000,null,6.00000,null,5.50000,null,6.00000,null,5.50000,null,5.00000,null,4.00000,null,3.00000};
    System.out.print("output   : ");
    for(int i=0; i<result.size(); i++) {
      System.out.print(result.get(i)+",");
    }
    System.out.println();
    System.out.print("Excepted : ");
    for(int i=0; i<expected.length; i++) {
      System.out.print(expected[i]+",");
    }
  }

  public MedianFinder() {
    counter = 0;
    numbers = new ArrayList<>();
    result = new ArrayList<>();
  }

  public void addNum(int num) {
    if(numbers == null ) {
      return;
    }
    numbers.add((double) num);
    Collections.sort(numbers);
  }

  public double findMedian() {
    if (numbers == null || numbers.size() == 0) {
      return -1.0;
    }
    if (numbers.size() % 2 == 0) {
      int right = (numbers.size() / 2);
      int left = right - 1;
      return ((numbers.get(right) + numbers.get(left)) / 2.0);
    } else {
      if(numbers.size() == 1) {
        return numbers.get(0);
      } else {
        return numbers.get((int) Math.ceil(numbers.size() / 2.0) -1);
      }
    }
  }
}
