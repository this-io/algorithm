package implementation.easy.peakindexinamountainarray;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PeakIndexInAMountainArray {
	public static void main(String[] args) {
		PeakIndexInAMountainArray a = new PeakIndexInAMountainArray();
		int[] input = {24,69,100,99,79,78,67,36,26,19};
		System.out.println("Result: "+ a.peakIndexInMountainArray(input));
	}

	/*public int peakIndexInMountainArray(int[] arr) {
		if (arr.length == 0) {
			return -1;
		}
		//Alogrithm linear scan
		int peakIndex = -1;
		int currentPeak = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > currentPeak) {
				peakIndex = i;
				currentPeak = arr[i];
			}
		}
		return peakIndex;
	}*/

	public int peakIndexInMountainArray(int[] arr) {
		if (arr.length == 0) {
			return -1;
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		Map<Integer, Integer> keeper = new HashMap<Integer, Integer>();
		for(int i =0; i<arr.length; i++) {
			maxHeap.add(arr[i]);
			keeper.put(arr[i], i);

		}
		System.out.println(maxHeap.peek());
		if(keeper.containsKey(maxHeap.peek())) {
			return keeper.get(maxHeap.peek());
		}
		return 0;
	}
}
