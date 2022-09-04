package main.implementation.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestCandies {
    public static void main(String[] args) {
        GreatestCandies sumOf1DArray = new GreatestCandies();
        sumOf1DArray.kidsWithCandies(null, 0);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if(candies == null || candies.length == 0) {
            return null;
        }
        int maxCandies = getGreatestNumberCandies(candies);
        System.out.println("Max== "+ maxCandies);
        List<Boolean> result = new ArrayList<>();
        for(int i=0; i<candies.length; i++){
            Boolean boolVal = false;
            if(candies[i] + extraCandies >= maxCandies){
                System.out.println("==="+"=="+candies[i]+"=="+(candies[i] + extraCandies >= maxCandies));
                boolVal = true;
            }
            result.add(boolVal);
        }
        return result;
    }

    private int getGreatestNumberCandies(int[] inputArray){
        if(inputArray == null || inputArray.length == 0) {
            return 0;
        }
        int maxValue = inputArray[0];
        for(int i=1;i < inputArray.length;i++){
            if(inputArray[i] > maxValue){
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }
}
