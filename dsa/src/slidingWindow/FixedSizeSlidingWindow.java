package slidingWindow;

public class FixedSizeSlidingWindow {
    /**
     * find maximum sum of subArray of given window size

     * **/
    public static int maxSumSubArray(int[] inputArray, int windowSize){

        /**
         * this can be achieved by sliding window algorithm
         * first find the sum of giving window using for loop upto given window size
         * **/
        int windowSum =0;
        int size = inputArray.length;
        if(size < windowSize) return -1;
        //sum of first window
        for(int i=0 ; i<windowSize; i++) {
            windowSum += inputArray[i];
        }
        int maxSum = windowSum;
        /**
         * Once Sum of first window is identified
         * slid window to its right by one element at a time
         * remove the first element and include the next element
         * compare the sum with previous window
         * if sum is higher assign this sum to maxSum**/
        //sliding window
        for(int i=windowSize; i < size; i++){
            windowSum += inputArray[i] - inputArray[i-windowSize];
            maxSum = Math.max(maxSum, windowSum);

            System.out.println("internal max"+maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] inputArray = {1,4,3,2,8,1,6,2,9,2,5};
        //int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println("max sum:"+maxSumSubArray(inputArray,k));
    }
}
