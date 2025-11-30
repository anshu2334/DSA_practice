package slidingWindow;

import java.util.Arrays;

public class MergeSortedArray {
    /** **
     * this method will take 2 sorted array and merge them in single Array
     * first Array has length to accomodate second Array
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        //start from right most element in both array and compare the values
        //if value in Array one is greater than value in array 2
        //insert num1 value in insert position
        int startingIndexArrayOne = m-1;
        int startingIndexArrayTwo = n-1;
        int insersionPoint = m+n-1;
        while(startingIndexArrayOne >= 0 && startingIndexArrayTwo >=0){
            if(nums1[startingIndexArrayOne] > nums2[startingIndexArrayTwo]) {
                nums1[insersionPoint--] =nums1[startingIndexArrayOne--];
            }else{
                nums1[insersionPoint--] =nums2[startingIndexArrayTwo--];
            }

        }

        while(startingIndexArrayTwo >= 0){
            nums1[insersionPoint--] =nums2[startingIndexArrayTwo--];
        }

    }
    public static int[] mergeSortedArray(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int[] resultArray = new int[m+n];

        // array one starting pointer
        int i =0;
        //array two starting pointer
        int j=0;
        //result array starting pointer
        int k=0;

        //compare values in 2 Arrays and put it in result Array
        while(i <m && j < n){
            if(nums1[i] <= nums2[j]) {
                resultArray[k++] = nums1[i++];
            }else{
                resultArray[k++] = nums2[j++];
                
            }
        }

        //merge remaining elements from array one
        while(i<m){
            resultArray[k++] = nums1[i++];
        }

        //merge remaining elements from array two
        while (j < n) {
            resultArray[k++] = nums2[j++];
        }

        return resultArray;

    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);

        System.out.print("Merged Array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }

        int[] nums3 = {1, 3, 5,9};
        int[] nums4 = {2, 4, 6};

        int[] result = mergeSortedArray(nums3, nums4);
        System.out.println("Merged Array: " + Arrays.toString(result));

    }

}
