package slidingWindow;

/**
 * variable size Sliding window algorithm is really helpful for scenarios where we have to compare
 * the subArray of variable length operations with any given target value**/
public class VariableSizeSlidingWindow {
    public static int minSubArrayLent(int[] inputArray, int target){
        int sum =0;
        int left =0;
        int n = inputArray.length;

        int minArrayLength = Integer.MAX_VALUE;
        for(int right =0; right < n; right++){
            // keep expending the window until operation value is more than target value
            sum += inputArray[right];
            while(sum >= target){
                //keep shrinking or narrowing the window until operation value is less than target value
                minArrayLength = Math.min(minArrayLength,right-left+1);
                System.out.println("min length per iteration: "+minArrayLength);
                System.out.println("sum before shrink: "+sum);
                sum -= inputArray[left];
                System.out.println("sum after shrink: "+sum);
                left++;
            }
        }
        return Integer.MAX_VALUE == minArrayLength ? 0 : minArrayLength;
    }

    public static void main(String[] args) {
        int[] inputArray = {2, 3, 1, 2, 4, 3};
        int target =7;
        System.out.println("minimum subArray length with sum greater than 7 is :"+minSubArrayLent(inputArray,target));
    }
}
