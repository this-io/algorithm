package implementation.easy;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MakeArrayZeroBySubtractingEqualAmounts {
    PriorityQueue pQ = new PriorityQueue();
    int totalSum = 0;
    public static void main(String[] args) {
        MakeArrayZeroBySubtractingEqualAmounts m = new MakeArrayZeroBySubtractingEqualAmounts();
        int[] k = new int[] {1, 1, 2,3,4};

        for(int n : k) {
            m.totalSum += n;
        }
        System.out.println(m.minimumOperations(k));
    }

    public int minimumOperations(int[] nums) {
        Set<Integer> unQue = new HashSet();
        for(int n : nums) {
            if(n > 0) {
                unQue.add(n);
            }
        }
        return unQue.size();
    }

}
