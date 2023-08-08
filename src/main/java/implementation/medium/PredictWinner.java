package implementation.medium;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class PredictWinner {
    public static void main(String[] args) {
        PredictWinner p = new PredictWinner();
        int[] ip = {1,5,2};
        System.out.println(p.predictTheWinner(ip));
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer total = Arrays.stream(nums).sum();

        int p1 = solve(0, n-1, nums);
        int p2 = total - p1;

        return p1 >= p2;
    }

    int solve(int i, int j , int[] nums) {
        if(i > j) {
            return 0;
        }

        if(i == j) {
            return nums[i];
        }

        int take1 = nums[i] + min(solve(i+2, j, nums), solve(i+1, j-1, nums));
        int take2 = nums[j] + min(solve(i, j -2, nums), solve(i+1, j-1, nums));
        return max(take1, take2);
    }
}
