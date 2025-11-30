package dynamicprograming;

public class UniquePath {
    public static int unquePathObstacle(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0][0] == 1) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (matrix[rows - 1][cols - 1] == 1) return 0;

        int[][] dp = new int[rows][cols];
        dp[0][0] = matrix[0][0] == 0 ? 1 : 0;
        //populate first column
        for (int i = 1; i < cols; i++) {
            dp[i][0] = (matrix[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
        }
        //populate first row
        for (int j = 1; j < rows; j++) {
            dp[0][j] = (matrix[0][j] == 0 && dp[0][j - 1] == 1) ? 1 : 0;
        }
        //fill DP
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[rows-1][cols-1];

    }

    public static int unquePathObstacleWithOneD(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0][0] == 1) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (matrix[rows - 1][cols - 1] == 1) return 0;

        int[] dp = new int[cols];
        dp[0] = matrix[0][0] == 0 ? 1 : 0;

        //fill DP
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    dp[j] =0;
                } else if(j > 0) {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[cols-1];

    }


    public static void main(String[] args) {
        int[][] matrix  = {
            {0,0,0},
                {0,1,0},
                {0,0,0},
        };
        System.out.println(unquePathObstacleWithOneD(matrix));
    }

}
