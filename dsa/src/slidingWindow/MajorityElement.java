package slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement
{
    public static int majorityElementBMVA(int[] inputs) {
        //boyer moore voting algorithm
        /** **?
         * Boyer–Moore Voting Algorithm (Optimal)
         * - Maintain a candidate and a count.
         * - Traverse the array:
         * - If count == 0, set candidate = num.
         * - If num == candidate, increment count.
         * - Else, decrement count.
         * - At the end, candidate is the majority element.
         * - Time: O(n), Space: O(1)
         */
        int candidate = 0;
        int count = 0;
        //int i=0;
        //Candidate Selection
        int majorityElementCount = 0;

        for(int i=0; i< inputs.length; i++) {
            int num = inputs[i];
            if(count==0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
            System.out.printf("(i=%d ) candidate=%d count=%d",i, candidate,count);
            System.out.println();
                    i++;

        }
        for(int i=0 ; i< inputs.length; i++){
            if(inputs[i] == candidate) majorityElementCount++;
        }

        return majorityElementCount > inputs.length/2 ? candidate : -1;
    }

    public static int majorityElementBySorting(int[] inputs){
        /**
         * Sort the array.
         * • 	The majority element must occupy the middle position ().
         * • 	Time: O(n log n), Space: O(1)
         * **/
        Arrays.sort(inputs);
        return inputs[inputs.length/2];
    }

    public static int majorityElementByFrequencyCount(int[] inputs){
        /**
         * - Count frequency of each element.
         * - Return the one with count > n/2.
         * - Time: O(n), Space: O(n).
         * **/
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int i=0; i<inputs.length; i++) {
            int count = frequencyMap.getOrDefault(inputs[i],0);
            frequencyMap.put(inputs[i], count+1);
            if(frequencyMap.get(inputs[i]) > inputs.length/2) {
                return inputs[i];
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {2,2,1,1,1,2,2};
        System.out.println(majorityElementBMVA(input));
        /**
         * dry run
         * i=0, candidate =2; count=1;
         * i=1, cadidate=2; count=2;
         * i=2 candidate=2; count=1;
         * i=3 candidate2; count=0;
         * i=4 candidate=1; count=1;
         * i=5 candiate=1; count=0
         *
         * **/
    }
}
