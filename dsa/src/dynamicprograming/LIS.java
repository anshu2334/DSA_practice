package dynamicprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LIS {
    //logest strictly increasing sequence
    public static int longestSequenc(int[] input){
        if(input == null || input.length == 0) return 0;
        int[] dp = new int[input.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=1; i<input.length; i++){
            for(int j=0; j<i;j++){
                if(input[j] < input[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        for (int num : nums) {
            int i = Collections.binarySearch(sub, num);
            System.out.printf(" before:%d ",i);
            if (i < 0) {i = -(i + 1); // insertion point
            System.out.printf(" after:%d ", i);
            }
            if (i == sub.size()) sub.add(num);
            else sub.set(i, num);
        }
        return sub.size();
    }

    public static int lengthOfLISs(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int longest = 1;
        Arrays.fill(nums, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] input = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLISs(input));
    }

    }
