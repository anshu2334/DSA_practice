package slidingWindow;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        /** **
         * Complexity
         * - Time: O(n) → single pass.
         * - Space: O(1)
         *
        **/
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest)
            {
                return false;
            } // stuck

            farthest = Math.max(farthest, i + nums[i]);
            System.out.println(farthest);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};

        System.out.println("Can Jump 1: " + canJump(nums1)); // true
        //System.out.println("Can Jump 2: " + canJump(nums2)); // false
    }
}
