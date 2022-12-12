package implementation.easy;

import java.lang.reflect.Array;
import java.util.stream.Collectors;

public class DecompressRunLength {
    public static void main(String[] args){
        DecompressRunLength decompressRunLength = new DecompressRunLength();
        int[] result = decompressRunLength.decompressRLElist(new int[]{1,2,3,4});
        for(int i=0; i<result.length; i++){
            System.out.println("=="+result[i]);
        }
    }

    public int[] decompressRLElist(int[] nums) {
        if(nums.length == 0 || nums.length%2 != 0 ){
            return new int[nums.length];
        }
        String result = "";
        int counter = 0;
        for(int i=0; i<nums.length; i+=2){
            for(int j=0; j<nums[i]; j++){
                result += String.valueOf(nums[i+1])+",";
                counter++;
            }
        }
        int[] result1 = new int[counter];
        String[] convrt = result.split(",");
        for(int i=0; i < convrt.length; i++){
            result1[i] =Integer.valueOf(convrt[i]);
        }
        return result1;
    }
}
