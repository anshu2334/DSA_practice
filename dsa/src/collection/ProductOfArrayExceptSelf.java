package collection;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] input) {

        int n = input.length;
        //Result array of same size as input array
        int[] result = new int[n];
        int zeroCount = 0;
        int totalProduct = 1;
        for (int i = 0; i < n; i++) {
            if (input[i] == 0) {
                zeroCount++;
            } else {
                totalProduct *= input[i];
            }
        }

        if (zeroCount > 1) {
            return result;
        } else if (zeroCount == 1) {
            for (int i = 0; i < n; i++) {
                if (input[i] == 0) {
                    result[i] = totalProduct;
                }
            }
        } else {

            //prefix multiplication
            result[0] = 1;
            for (int i = 1; i < n; i++) {
                //insert prefix multiplication for each index
                result[i] = result[i - 1] * input[i - 1];
            }
            //Arrays.stream(result).forEach(System.out::println);

            //suffic multiplication is pending
            int suffix = 1;
            for (int i = n - 1; i >= 0; i--) {
                //multiply prefix and suffix for each index starting from
                // right most index as it has no suffix means its suffix is one
                result[i] *= suffix;
                //calculate the  suffix for left element . logic is simple. previous suffix * current input value
                suffix *= input[i];
            }
            }

            /**
             * Complexity
             * - Time: O(n) → two passes (prefix + suffix).
             * - Space: O(1) extra (excluding output array).
             *
             * ⚡ Key Takeaway
             * - Division is disallowed because of zeros in the array.
             * - Prefix + suffix trick is the optimal solution.
             * - This pattern (precompute left and right contributions) is very common in array problems.
             *
             **/
            return result;


    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = productExceptSelf(nums);

        for (int val : result) {
            System.out.print(val + " ");
        }
        // Output: 24 12 8 6
    }

}
