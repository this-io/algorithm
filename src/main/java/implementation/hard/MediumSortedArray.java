package implementation.hard;
import java.math.*;

public class MediumSortedArray {
    public static void main(String[] args) {
        MediumSortedArray mediumSortedArray = new MediumSortedArray();
        double result = mediumSortedArray.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println("===result===" + result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] shortInput;
        int[] longInput;
        if (nums1.length > nums2.length) {
            shortInput = nums2;
            longInput = nums1;
        } else {
            shortInput = nums1;
            longInput = nums2;
        }
        int left = 0
            , right = shortInput.length
            , lShort = 1
            , rShort = 1
            , lLong = 1
            , rLong = 1
            , direction = 1;
        while (direction != 0) {
            //1,3
            //2
            int mid = (left + right) / 2;  //1
            rLong = getIndices(mid, longInput, shortInput);  //1, {1,3}, {2}
            lLong = rLong - 1;      //
            lShort = mid - 1;
            rShort = mid;
            direction = getDirection(lShort, rShort, lLong, rLong, shortInput, longInput);
            if (direction < 0) {
                right = mid - 1;
            }
            if (direction > 0) {
                left = mid + 1;
            }
        }
        return getResult(lShort, rShort, lLong, rLong, shortInput, longInput);
    }

    private int getVal(int[] arr, int i) {
        double INF = Double.POSITIVE_INFINITY;
        if (i == -1) {
            return (int) INF * -1;
        }
        if (i == arr.length) {
            return (int) INF;
        }
        return arr[i];
    }

    private int getDirection(int lShort, int rShort, int lLong, int rLong, int[] shortInput, int[] longInput) {
        if (getVal(shortInput, lShort) > getVal(longInput, rLong)) {
            return -1;
        } else if (getVal(longInput, lLong) > getVal(shortInput, rShort)) {
            return 1;
        } else {
            return 0;
        }
    }

    private double getResult(int lShort, int rShort, int lLong, int rLong, int[] shortInput, int[] longInput) {
        int odd = (shortInput.length + longInput.length) % 2;
        if (odd != 0) {
            return Math.min(getVal(longInput, rLong), getVal(shortInput, rShort));
        } else {
            return (Math.max(getVal(shortInput, lShort), getVal(longInput, lLong))
                    + Math.min(getVal(shortInput, rShort), getVal(longInput, rLong))) / 2.0;
        }
    }

    private int getIndices(int rShort, int[] longInput, int[] shortInput) {
        int midIndex = (shortInput.length + longInput.length) / 2;   //1+2/2 = 1
        return midIndex - rShort;                              //1-1 = 0
    }
}
