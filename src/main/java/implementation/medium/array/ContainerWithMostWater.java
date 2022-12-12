package implementation.medium.array;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		ContainerWithMostWater c = new ContainerWithMostWater();
		int heigth[] = {1,8,6,2,5,4,8,3,7};
		int water = c.maxArea(heigth);
		System.out.println(water);
	}

	public int maxArea(int[] height) {
		int water=0;
		int left = 0;
		int right = height.length - 1;

		while(left<=right) {
			int currentWater = 0;
			if(height[left] < height[right]) {
				currentWater = height[left] * (right - left);
				left ++;
			} else {
				currentWater = height[right] * (right - left);
				right --;
			}
			if(water < currentWater) {
				water = currentWater;
			}
		}

		return water;
	}

	public int maxAreaBruteForce(int[] height) {
		int water = 0;
		for(int i=0; i < height.length; i++) {
			for(int j = i+1; j< height.length; j++) {
				int smaller=0;
				if(height[i] == 0) {
					continue;
				}
				if(height[i] < height[j]) {
					smaller = height[i];
				} else {
					smaller = height[j];
				}
				int currentWater = smaller * (j - i);
				if(water < currentWater) {
					water = currentWater;
				}
			}
		}

		System.out.println(water);
		return water;
	}
}
