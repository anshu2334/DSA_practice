package slidingWindow;

import java.util.HashMap;

public class RemoveFrequencyDuplicateUnsorted {
    public static int removeDuplicates(int[] nums, int duplicationAllowedLevel) {
        //fequency counter
        HashMap<Integer, Integer> freq = new HashMap<>();
        int k = 0; // write pointer

        for (int i = 0; i < nums.length; i++) {
            int count = freq.getOrDefault(nums[i], 0);

            if (count < duplicationAllowedLevel) {
                nums[k] = nums[i];
                k++;
                freq.put(nums[i], count + 1);
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 2, 2, 2, 4, 1, 5, 1};
        int allowed = 2;
        int k = removeDuplicates(nums, allowed);

        System.out.println("New length: " + k);
        System.out.print("Array after removal: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
