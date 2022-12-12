package implementation.easy.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class DegreeOfAnArray {
    public static void main(String[] args) {
        DegreeOfAnArray d = new DegreeOfAnArray();
        //int[] ip = {1,2,2,3,1};
        int[] ip = {1,2,2,3,1,4,2};
        System.out.println(d.findShortestSubArray(ip));
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> leftPosition = new HashMap<>();
        Map<Integer, Integer> rightPosition = new HashMap<>();
        Map<Integer, Integer> counter = new HashMap<>();

        int count = 0;
        for(int i : nums) {
            if(!leftPosition.containsKey(i)) {
                leftPosition.put(i, count);
            }
            rightPosition.put(i, count);
            counter.put(i, counter.getOrDefault(i, 0) + 1);
            count++;
        }
        int degree = Collections.max(counter.values());
        int op = nums.length;
        for(int i : counter.keySet()) {
            if(degree == counter.get(i)) {
                op = Math.min(op, ((rightPosition.get(i) - leftPosition.get(i)) + 1));
            }
        }

        return op;
    }
}
