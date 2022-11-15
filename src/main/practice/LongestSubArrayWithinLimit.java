package main.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LongestSubArrayWithinLimit {
  public static void main(String[] args) {
    LongestSubArrayWithinLimit l = new LongestSubArrayWithinLimit();
//    int[] arr = {8, 2, 4, 7};
//    int limit = 4;
//    int[] arr1 = {1000};
//    int limit1 = 10;
//    int[] arr2 = {10,1,2,4,7,2};
//    int limit2 = 5;
//    int[] arr4 = {4,2,2,2,4,4,2,2};
//    int limit4 = 0;
    int[] arr5 = {1,5,6,7,8,10,6,5,6};
    int limit5 = 4;
//    int[] arr6 = {4,2,2,2,4,4,2,2};
//    int limit6 = 0;
//    System.out.println("arr ==> "+ l.longestSubString(arr, limit));
//    System.out.println("arr1 ==> "+l.longestSubString(arr1, limit1));
    //System.out.println("arr2==> "+l.longestSubString(arr2, limit2));
//    System.out.println("arr4 ==> "+l.longestSubString(arr4, limit4));
    System.out.println("arr5 ==> "+l.longestSubString(arr5, limit5));
    //System.out.println("arr6 ==> "+l.longestSubString(arr6, limit6));

  }

//  public int longestSubString(int[] ar, int l) {
//    PriorityQueue<Integer> thePQueue = new PriorityQueue(Collections.reverseOrder());
//    for (int i = 0; i < ar.length; i++) {
//      List<Integer> cap = new ArrayList<>();
//      for (int j = i; j < ar.length; j++) {
//        int dif = ar[i] - ar[j];
//        if (dif < 0) {
//          dif *= -1;
//        }
//        if (dif <= l) {
//          cap.add(ar[j]);
//        } else {
//          break;
//        }
//      }
//      //System.out.println(cap.size());
//      thePQueue.add(cap.size());
//    }
//
//    return (thePQueue.size() > 0) ? thePQueue.peek() : 0;
//  }

  public int longestSubString(int[] ar, int l) {
    if(ar.length == 1) {
      return 1;
    }

    return 0;
  }
}
