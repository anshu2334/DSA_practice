package slidingWindow;

import java.util.Arrays;

public class RemoveDuplicateFromArray {
    public static int removeDuplicates(int[] input){
        int k =1; //write position starting from second element as first is always unique

        for(int i=1; i< input.length; i++){
            if(input[i] != input[k-1]){
                input[k] = input[i];
                k++;

            }


        }

        return k;
    }

    public static void main(String[] args) {
        int[] input = {0,0,0,1,1,2,2,2,5,6,7,7,7};
        int k = removeDuplicates(input);
        System.out.println("elements remaining after duplicate removal:"+k);
        Arrays.stream(input).limit(k).forEach(System.out::println);
    }
}
