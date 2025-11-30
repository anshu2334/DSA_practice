package collection;

public class Manacher {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Step 1: Transform the string with separators (#) to handle even-length palindromes
        StringBuilder t = new StringBuilder("^"); // sentinel at start
        for (char c : s.toCharArray()) {
            t.append("#").append(c);
        }
        t.append("#$"); // sentinel at end

        // Step 2: Array to store palindrome radii
        int n = t.length();
        int[] P = new int[n]; // P[i] = radius of palindrome centered at i
        int center = 0, right = 0;

        // Step 3: Main loop
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i; // mirror index of i around center


            // Initialize P[i] using mirror or boundary
            if (i < right) {
                P[i] = Math.min(right - i, P[mirror]);

            }

            // Expand around center i
            while (t.charAt(i + 1 + P[i]) == t.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // Update center and right boundary if expanded beyond current right
            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
            System.out.printf("mirror:%d  center:%d  right=%d radii=%d i=%d",mirror, center, right,P[i],i);
            System.out.println();
        }

        // Step 4: Find max palindrome length
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        // Step 5: Extract substring from original string
        int start = (centerIndex - maxLen) / 2; // map back to original string
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // "bab" or "aba"
        System.out.println(longestPalindrome("cbbd"));  // "bb"
    }
}

