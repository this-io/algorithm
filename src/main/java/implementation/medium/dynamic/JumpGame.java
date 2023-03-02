package implementation.medium.dynamic;

public class JumpGame {

    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        int[] ip = {3,2,1,0,4};
        System.out.println(j.canJump(ip));
    }

    public boolean canJump(int[] nums) {
        int end_idx = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= end_idx) {
                end_idx = i;
            }
        }
        return end_idx == 0;
    }
}
