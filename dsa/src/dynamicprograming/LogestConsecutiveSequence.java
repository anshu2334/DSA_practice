package dynamicprograming;

import java.util.*;

public class LogestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> dp = new HashMap<>();
        int longest = 0;

        for (int num : nums) {
            if (!dp.containsKey(num)) {
                int left = dp.getOrDefault(num - 1, 0);
                int right = dp.getOrDefault(num + 1, 0);
                int length = left + right + 1;

                // Update current number
                dp.put(num, length);

                // Update boundaries of the sequence
                System.out.printf("num:%d left:%d right=%d",num,left,right);
                System.out.println();
                dp.put(num - left, length);
                dp.put(num + right, length);

                longest = Math.max(longest, length);
            }
        }
        dp.entrySet().forEach((e) ->{
            System.out.printf("%d:%d",e.getKey(),e.getValue());
            System.out.println();
        });

        return longest;
    }

    public int longestConsecutiveHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            // Only start if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] input = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(input));
    }
}
