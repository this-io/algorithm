package implementation.medium;

public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        MinimumMovesToEqualArrayElements m = new MinimumMovesToEqualArrayElements();
        int[] n = {1,1,1};
        System.out.println(m.minMoves(n));
    }

    public int minMoves(int[] nums) {
        int sum = 0;
        int minElement = Integer.MAX_VALUE;

        for(int looper : nums) {
            sum += looper;
            minElement = Math.min(minElement, looper);
        }

        return sum - minElement * nums.length;
    }
}
