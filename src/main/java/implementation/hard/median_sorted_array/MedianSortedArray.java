package implementation.hard.median_sorted_array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MedianSortedArray {
    public static void main(String[] args) {
        int[] num1 = {};
        int[] num2 = {1};
        MedianSortedArray m = new MedianSortedArray();
        System.out.println(m.findMedianSortedArrays(num1, num2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        System.out.println("This si");
        List<Integer> biggerList = new ArrayList<>();
        int counter = 0;
        for(int i : nums1) {
            biggerList.add(i);
        }

        for(int i : nums2) {
            biggerList.add(i);
        }
        Collections.sort(biggerList);
        int mid = biggerList.size()/2;
        if( biggerList.size()%2 == 0) {
            int mid1 = biggerList.get(mid);
            int mid2 = biggerList.get(mid - 1);
            return ((double)(mid1+mid2)/2);
        } else {
            return biggerList.get(mid);
        }
    }
}
