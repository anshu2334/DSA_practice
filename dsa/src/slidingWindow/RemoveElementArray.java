package slidingWindow;

import java.util.Arrays;

public class RemoveElementArray {
    public static int removeDuplicates(int[] input, int target){
        if(input == null || input.length ==0) return 0;
        int size = input.length;
        int k=0; //write index for the next element
        for(int i=0; i< size;i++) {
            if(input[i] != target) {
                if(k != i) {
                    input[k] = input[i];
                }
                k++;
            }
            // if value at i matches target value then write index will not be increased
            //hence next non matching element will replace this value
        }
        Arrays.stream(input).limit(k).forEach(System.out::println);
        return k;

    }

    public static void main(String[] args) {
        int[] input = {3,1,4,3,2,5};
        int target =3;
        System.out.println("remaining elements after element removal:"+removeDuplicates(input,target));
    }


}
