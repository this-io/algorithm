package main.implementation.hard.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {
  private static PriorityQueue leftHeap;
  private static PriorityQueue rightHeap;
  private static List<Double> result = new ArrayList<>();

  public static void main(String[] args) {
    //String[] ops = {"MedianFinder", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian"};
    //int[][] input = {{}, {6}, {}, {10}, {}, {2}, {}, {6}, {}, {5}, {}, {0}, {}, {6}, {}, {3}, {}, {1}, {}, {0}, {}, {0}, {}};
    String[] ops = {"MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"};
    int[][] input = {{}, {1}, {2}, {}, {3}, {}};
    MedianFinder medianFinder = null;
    double currentMedian = 0;
    for (int i = 0; i < ops.length; i++) {
      if (ops[i].equalsIgnoreCase("MedianFinder")) {
        medianFinder = new MedianFinder();
        result.add(null);
      } else if (ops[i].equalsIgnoreCase("addNum")) {
        medianFinder.addNum(input[i][0]);
//        System.out.println(input[i][0]);
//        System.out.println("Left Heap size ::" + leftHeap.size());
//        System.out.println("Right Heap size ::" + rightHeap.size());
        result.add(null);
      } else if (ops[i].equalsIgnoreCase("findMedian")) {
        currentMedian = medianFinder.findMedian();
        result.add(currentMedian);
      } else {
        System.out.println("I ain't doing it..");
      }
    }
//    Double[] expected = {null, null, 6.00000, null, 8.00000, null, 6.00000, null, 6.00000, null, 6.00000, null
//            , 5.50000, null, 6.00000, null, 5.50000, null, 5.00000, null, 4.00000, null, 3.00000};
    Double[] expected = {null,null,null,1.50000,null,2.00000};
    System.out.print("Output   : ");
    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i) + ",");
    }
    System.out.println();
    System.out.print("Expected : ");
    for (Double d : expected) {
      System.out.print(d + ",");
    }
  }

  public MedianFinder() {
    rightHeap = new PriorityQueue();
    leftHeap = new PriorityQueue(Comparator.reverseOrder());
  }

  public void addNum(int num) {
    leftHeap.add((double) num);

    if (leftHeap.size() - rightHeap.size() > 1) {
      swapMaxFromMinHeapToMaxHeap();
    }

    if (rightHeap.size() - leftHeap.size() > 1) {
      swapMinFromMxnHeapToMixHeap();
    }
    double leftPeek = -1;
    if(leftHeap.size() > 0) {
      leftPeek = (double)leftHeap.peek();
    }
    double rightPeek = -1;
    if(rightHeap.size() > 0) {
      rightPeek = (double)rightHeap.peek();
    }
    if(leftPeek != -1 && rightPeek != -1 && leftPeek > rightPeek){
      leftHeap.remove();
      rightHeap.remove();
      leftHeap.add(rightPeek);
      rightHeap.add(leftPeek);
    }
  }

  private void swapMinFromMxnHeapToMixHeap() {
    double minFromMaxHeap = (double) rightHeap.remove();
    leftHeap.add(minFromMaxHeap);
  }

  private void swapMaxFromMinHeapToMaxHeap() {
    double maxFromMinHeap = (double) leftHeap.remove();
    rightHeap.add(maxFromMinHeap);
  }

  public double findMedian() {
    if ((leftHeap.size() + rightHeap.size()) % 2 == 0) {
      return (((double) leftHeap.peek() + (double) rightHeap.peek()) / 2.0);
    } else {
      if (leftHeap.size() > rightHeap.size()) {
//        System.out.println("left peek : "+ (double) leftHeap.peek());
        return (double) leftHeap.peek();
      } else {
//        System.out.println("right peek : "+ (double) rightHeap.peek());
        return (double) rightHeap.peek();
      }
    }
  }
}
