package collection;

public class MaximalSquare {
    public static int getMaximalSquareWithDPMatrix(char[][] matrix){
        if(matrix== null || matrix.length ==0) return 0;

        int row = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[row+1][cols+1]; //with padded as this is going to start keeping value from index one till end

        int maxSide = 0;
        for(int i=1; i<=row;i++){
            for(int j=1; j<=cols; j++){
                /**
                 * Solution Approach (Dynamic Programming)
                 * Key Idea
                 * - If matrix[i][j] == 1, then the largest square ending at (i, j) depends on:
                 * - Top (dp[i-1][j])
                 * - Left (dp[i][j-1])
                 * - Top-left (dp[i-1][j-1])
                 * - Formula:
                 * dp[i][j]=\min (dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1- Keep track of the maximum side length seen so far.
                 * **/
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]= Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }else {
                    dp[i][j]=0;
                }
            }
        }
        return maxSide * maxSide;
    }

    public static int getMaximalSquareWithDPARRAYMatrix(char[][] matrix){
        if(matrix== null || matrix.length ==0) return 0;

        int row = matrix.length, cols = matrix[0].length;
        int[] dp = new int[cols+1]; //with padded as this is going to start keeping value from index one till end

        int maxSide = 0;
        for(int i=1; i<=row;i++){
            int prevDiagonal = 0;
            for(int j=1; j<=cols; j++){
                /**
                 * Solution Approach (Dynamic Programming)
                 * Key Idea
                 * - If matrix[i][j] == 1, then the largest square ending at (i, j) depends on:
                 * - Top (dp[i-1][j])
                 * - Left (dp[i][j-1])
                 * - Top-left (dp[i-1][j-1])
                 * - Formula:
                 * dp[i][j]=\min (dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1- Keep track of the maximum side length seen so far.
                 * **/
                if(matrix[i-1][j-1]=='1'){
                    int temp = dp[j];
                    dp[j]= Math.min(Math.min(dp[j],dp[j-1]),prevDiagonal) + 1;
                    maxSide = Math.max(maxSide, dp[j]);
                    prevDiagonal = temp;

                }else {
                    dp[j] =0;
                }
            }
        }
        return maxSide * maxSide;
    }


    public static void main(String[] args) {


        // Sample matrix from the problem statement
        char[][] matrix = {
                {'1','0','1','1','1'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        char[][] matrix1 =
                {
                        {'1','1','1','1','1'},
                        {'1','1','1','1','1'},
                        {'0','0','0','0','0'},
                        {'1','1','1','1','1'},
                        {'1','1','1','1','1'}
                };

        int result = getMaximalSquareWithDPMatrix(matrix1);
        System.out.println("Maximal Square Area: " + result);
    }

}
