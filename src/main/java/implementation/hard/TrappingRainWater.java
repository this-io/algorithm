package implementation.hard;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        //int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4,2,0,3,2,5};
        System.out.println(t.trap(height));
    }

    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        int total = 0;
        while(left < right) {
            if(maxLeft < maxRight) {
                left++;
                int waterInSegment = maxLeft - height[left];
                total += (waterInSegment < 0) ? 0 : waterInSegment;
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                right--;
                int waterInSegment = maxRight - height[right];
                total += (waterInSegment < 0) ? 0 : waterInSegment;
                maxRight = Math.max(maxRight, height[right]);
            }
        }
        return total;
    }
}
