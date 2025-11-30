package dynamicprograming;

public class MinimumDistance {
    public static int minDistanceWith2DArray(String word1, String word2) {
        //Levenshtein Algorithm- Calculate minimum number of single charachter edit required
        // to transfored one string into another
        //minimum distance or steps to replace word1 with word2
        int m = word1.length();
        int n = word2.length();
        //this is going to hold min distance at each position
        int[][] dp = new int[m+1][n+1];

        //base cases
        for(int i=0; i<= m; i++) {
            //all delete characters at each row
            //first row
            dp[i][0]=i;

        }

        for(int j=0; j<=n; j++){
            //All insert characters at each index
            //zeroth column
            dp[0][j] = j;
        }

        for(int i=1; i<=m;i++){
           // System.out.printf("Row:%s ",word1.substring(0,i));
            for(int j=1; j<=n;j++){
                //System.out.printf("Column:%s ",word2.substring(0,j));
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; // no operartion needed
                } else {
                    dp[i][j] = 1+ Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
                //System.out.printf("dp[%s][%s] (%2d)  ",i,j,dp[i][j]);
            }
            //System.out.println();
        }
        return dp[m][n];
    }

    public static int minDistanceWith1DArray(String word1, String word2) {
        //Levenshtein Algorithm- Calculate minimum number of single charachter edit required
        // to transfored one string into another
        //minimum distance or steps to replace word1 with word2
        int m = word1.length();
        int n = word2.length();

        //create 2 one D Arrays with length
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(
                            prev[j],    // delete
                            Math.min(curr[j - 1], // insert
                                    prev[j - 1]) // replace
                    );
                }
            }
            // swap rows
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];

    }


    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistanceWith2DArray(word1,word2));
        System.out.println(minDistanceWith1DArray(word1,word2));
    }
}
