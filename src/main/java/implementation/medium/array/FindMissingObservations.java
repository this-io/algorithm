package implementation.medium.array;

import java.util.Arrays;

public class FindMissingObservations {
    public static void main(String[] args) {
        FindMissingObservations f = new FindMissingObservations();
        int[] arr = {1,5,6};
        int[] ans = f.missingRolls(arr, 3, 4);

        for(int i : ans) {
            System.out.print(i + "\t");
        }

    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int currSum = Arrays.stream(rolls).sum();
        int m = rolls.length;
        int missingSum = mean * (n + m) - currSum;

        if(missingSum < n || missingSum > 6 *n) {
            return new int[0];
        }

        int part = missingSum/n, rem = missingSum % n;
        int[] ans = new int[n];
        Arrays.fill(ans, part);

        for(int i =0; i< rem; i++) {
            ans[i]++;
        }

        return ans;
    }
}
