package collection;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int left =0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        int water = 0; // to hold result
        /**
         * Complexity
         * • 	Time: O(n) → single pass.
         * • 	Space: O(1).
         * **/

        while (left < right) {
            if(height[left] < height[right]) {
                //water capacity will be calculated based on left bars
                if(height[left] >= leftMax) {
                    //if leftmax is less than or equal to current value,set current value as new leftMax
                    leftMax = height[left];
                } else {
                    // if leftmax is greater than current value, calculate water trapped at that point
                    water += leftMax -height[left];
                }
                left++;
            }else {
                //water trapped capacity will be calculated based on right bars
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else
                {
                    water += rightMax - height[right];
                }
            right--;}
        }
        return water;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height)); // 6
    }
}
