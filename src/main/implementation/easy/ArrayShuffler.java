package main.implementation.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrayShuffler {
    public static void main(String[] args){
        int n = 3;
        int[] nums= {2,5,1,3,4,7,8};

        ArrayShuffler a = new ArrayShuffler();
        //a.shuffle(nums, n);
        for(int i : a.shuffle(nums,n)) {
            System.out.print(i + " ");
        }
    }

    private int[] shuffle(int[] nums, int n){
        int[] result = new int[nums.length];
        if(n != 0){
            int dvdr = nums.length/2;
            Map<Integer, ArrayList<Integer>> keyToGroup = new HashMap<Integer, ArrayList<Integer>>();
            for(int i=0; i<result.length; i++){
                Integer mods = i%dvdr;
                if(keyToGroup.containsKey(i%dvdr)){
                    ArrayList<Integer> ff = keyToGroup.get(mods);
                    ff.add(nums[i]);
                    keyToGroup.put(mods, ff);
                } else {
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    a.add(Integer.valueOf(nums[i]));
                    keyToGroup.put(mods, a);
                }
            }
            int counter=0;
            for(Integer i : keyToGroup.keySet()){
                for(Integer k : keyToGroup.get(i)){
                    result[counter] = k;
                    counter++;
                }
            }
        }
        return result;
    }
}
