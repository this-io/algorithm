package implementation.medium.heap;

import java.util.*;

public class TopKFrequentElement {
  public static void main(String[] args) {
    TopKFrequentElement t = new TopKFrequentElement();
    //int[] nums = {1, 1, 1, 1, 2, 2, 2, 3};
    //int k = 2;
    int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
    int k = 10;
    int[] r = t.topKFrequent(nums, k);

    for (int h : r) {
      System.out.print(h + "  ");
    }
  }

  public int[] topKFrequent(int[] nums, int k) {
    if (nums.length == 0) {
      return new int[0];
    }

    PriorityQueue thePQueue = new PriorityQueue(Comparator.reverseOrder());
    Map<Integer, Integer> integerToCount = new HashMap<>();
    Map<Integer, List<Integer>> countToIntegers = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (integerToCount.containsKey(nums[i])) {
        int temp = integerToCount.get(nums[i]);
        temp++;
        integerToCount.put(nums[i], temp);
      } else {
        integerToCount.put(nums[i], 1);
      }
    }
    for (int q : integerToCount.keySet()) {
      System.out.println(q + " : " + integerToCount.get(q));
    }
    System.out.println("#####===============");
    Set<Integer> theSet = new HashSet<>();

    for (int key : integerToCount.keySet()) {
      int count = integerToCount.get(key);
      theSet.add(count);
      if (countToIntegers.containsKey(count)) {
        List<Integer> temp = countToIntegers.get(count);
        temp.add(key);
        countToIntegers.put(count, temp);
      } else {
        List<Integer> temp = new ArrayList<>();
        temp.add(key);
        countToIntegers.put(count, temp);
      }
    }
    for(int l : theSet) {
      thePQueue.add(l);
    }
    for (int q : countToIntegers.keySet()) {
      System.out.print(q + " : ");
      for (int w : countToIntegers.get(q)) {
        System.out.print(w + ", ");
      }
      System.out.println();
    }

    System.out.println("+++++===============");
    List<Integer> preResult = new ArrayList<>();
    int firstSizePQueue = thePQueue.size();
    for (int i = 0; i < firstSizePQueue; i++) {
      int f = (int) thePQueue.remove();
      for (int j : countToIntegers.get(f)) {
        if(preResult.size() == k) {
          break;
        } else {
          preResult.add(j);
        }
      }
    }

    int[] result = new int[k];
    for(int i=0; i<k; i++) {
      result[i] = preResult.get(i);
    }
    return result;
  }
}
