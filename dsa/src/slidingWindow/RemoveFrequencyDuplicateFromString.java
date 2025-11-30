package slidingWindow;

import java.util.HashMap;

public class RemoveFrequencyDuplicateFromString {
    public static String removeDuplicates(String s, int duplicationAllowedLevel) {
        HashMap<Character, Integer> freq = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            int count = freq.getOrDefault(c, 0);

            if (count < duplicationAllowedLevel) {
                result.append(c);
                freq.put(c, count + 1);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "aaabbccccddeee";
        int allowed = 2;
        String result = removeDuplicates(s, allowed);

        System.out.println("Original: " + s);
        System.out.println("Processed: " + result);
    }
}
