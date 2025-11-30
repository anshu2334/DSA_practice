package slidingWindow;

import java.util.Arrays;
import java.util.Comparator;

/**
 * cyclic replacement method
 *  Idea Behind Cyclic Replacement
 * - When you rotate an array by k steps, each element moves to a new index (i + k) % n.
 * - If you follow this movement, you’ll notice it forms cycles (like a permutation of indices).
 * - The trick: move elements one by one along their cycle until you return to the starting point, then start a new cycle until all elements are moved.
 * **/
public class RotateArrayCyclic {
    static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int count = 0; //number of elements moved

        /**
         * When we are rotatic Array with K elements
         * this movement is forming cyclic pattern
         * where next element index is getting identified by (current elemet index + k) % array size
         * start iterating array elements starting from left index
         * keep track of current processing index and value of current Processing index
         * have do while loop to move values from current index to next identified index until start and current is not same
         * for each do-while matching iteration, calculate next index as  (current elemet index + k) % array size
         * keep the current value at next index in temp variable
         * assign new value to next index from current index
         * assign temp value to current index value
         * move current index pointer to next index pointer e.g current = next;
         * increase the moved count by one
         * repeate this for other cycles until main for loop condition moved element count < Array size
         * **/

        //compare with number of element moved
        for(int start =0; count < n ; start++) {
            int current = start;
            int previous = nums[start];


            do{
                //next move or write index is calculate as (current index + rotationSize) % Array length
                int next =(current+k) % n;
                //keep the current value of element at index next in temp variable
                // as this is going to be become previous value
                int temp = nums[next];
                //assign previous value to next index
                nums[next]  = previous;

                //assign next index to previous one
                previous = temp;
                System.out.printf("start:%d  next:%d, current:%d",start,next,current);
                //move current pointer to next index
                current =next;
                //increment moved element count element moved
                count++;

                System.out.println();
            }while(start != current);
        }
    }

    public static void rotateArray(int[] nums, int k){
        if(nums ==null || nums.length ==0 || k ==0 || k == nums.length) return;
        int n = nums.length;
        k = k%n;
        int count = 0; //moved element counts
        //iterate over array elements starting from left index until moved element count is less than array size
        for(int cycle=0; count <n; cycle++ ) {
            int current = cycle;
            int previous = nums[cycle];
            do{
                //calculate the next index
                int next = (current +k) % n;
                //hold current value at index next to temp variable
                int temp = nums[next];
                //assign current index value to next index
                nums[next] = previous;
                //assign temp variable to current index
                previous = temp;
                //move current index to point to next index
                current = next;
                //increment moved element count by one
                count++;
            }while(current !=cycle);
        }
        System.out.println();
        Arrays.stream(nums).forEach(s -> System.out.printf("%d ",s));
    }

    public static void rotateArrayByReversing(int[] nums, int k){
        //reverse Array
        reverse(nums,0,nums.length-1);

        //rev upto k
        reverse(nums, 0, k-1);
        //rev remaining
       reverse(nums, k, nums.length-1);

        Arrays.stream(nums).forEach(s -> System.out.printf("%d ",s));
        System.out.println();
    }

    public static void reverse(int[] nums, int startIndex, int endIndex){
        int left=startIndex, right = endIndex;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,9,6};
        int[] nums1 = {1,2,3,4,9,6};

        rotateArrayByReversing(nums, 2);

        //for (int num : nums) System.out.print(num + " ");

        rotateArray(nums1,2);
    }

}
