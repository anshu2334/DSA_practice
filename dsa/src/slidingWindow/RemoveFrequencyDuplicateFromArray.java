package slidingWindow;

import java.util.Arrays;

public class RemoveFrequencyDuplicateFromArray {
    public static int removeDuplicates(int[] input, int duplicationAllowedLevel){
        int k =0; //write position
        for(int i=0; i< input.length; i++){
            if((k < duplicationAllowedLevel) || input[i] != input[k-duplicationAllowedLevel]){
                input[k] = input[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] input = {0,0,0,1,1,2,2,2,5,6,7,7,7,7,7,7};
        int k = removeDuplicates(input,2);
        System.out.println("elements remaining after duplicate removal:"+k);
        Arrays.stream(input).limit(k).forEach(System.out::println);
    }
}
