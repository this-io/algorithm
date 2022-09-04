package main.implementation.easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetArrayGivenOrder {
    public static void main(String[] args) {
        TargetArrayGivenOrder targetArrayGivenOrder = new TargetArrayGivenOrder();
        int[] result = targetArrayGivenOrder.createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1});
        for(int i=0; i<result.length;i++){
            System.out.println(result[i]);
        }

    }

    public int[] createTargetArray(int[] nums, int[] index) {
        Map<Integer, ArrayList<Integer>> positionToNumber = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (positionToNumber.containsKey(index[i])) {
                ArrayList<Integer> temp = positionToNumber.get(index[i]);
                temp.add(nums[i]);
                positionToNumber.put(index[i], temp);
            } else {
                positionToNumber.put(index[i], new ArrayList<>(nums[i]));
            }
        }
        System.out.println(positionToNumber.size());
        int[] result = new int[positionToNumber.size()];
        for(int i=0; i<nums.length; i++){
            if(positionToNumber.containsKey(i)){
                for(int j=0; j<positionToNumber.get(i).size(); j++){
                    result[i] = positionToNumber.get(i).get(j);
                }
            }
        }
        return result;
    }
}
