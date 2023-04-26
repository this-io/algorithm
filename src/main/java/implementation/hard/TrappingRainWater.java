package implementation.hard;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        int[] heights = {4,2,0,3,2,5};//{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(t.trap(heights));
    }
    public int trap(int[] height) {
        int left =0, right = height.length -1;
        int leftMax = height[left], rightMax = height[right];

        int trappedWater = 0;

        while(left < right) {
            int waterTrappedInIteration = 0;
            if(leftMax < rightMax) {
                left++;
                waterTrappedInIteration = leftMax - height[left];
                leftMax = Math.max(leftMax, height[left]);
            } else {
                right--;
                waterTrappedInIteration = rightMax - height[right];
                rightMax = Math.max(rightMax, height[right]);
            }
            trappedWater += (waterTrappedInIteration < 0) ? 0 : waterTrappedInIteration;
        }

        return trappedWater;
    }
}
