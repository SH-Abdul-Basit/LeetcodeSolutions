
public class ContainerWithMostWater {
	public static void main(String[] args) {
		
	}	
	
	// To slow O(n^2) complexity
	public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                // calculating area
                int h = Math.min(height[i], height[j]);
                int w = Math.abs(i - j);
                int area = w * h;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
	
	// Faster method using two pointer method
	// Time complexity O(n)
	public int maxArea2(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxArea = Math.max(maxArea, h * w);

            // move the shorter side inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
