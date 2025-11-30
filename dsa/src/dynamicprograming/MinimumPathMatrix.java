package dynamicprograming;

public class MinimumPathMatrix {
    public static int minPath(int[][] matrix){
        if(matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] dp = new int[cols];
        dp[0] = matrix[0][0];

        //populate sum for first row
        for(int j=1; j< cols;j++){
            dp[j] = dp[j-1] + matrix[0][j];
        }

        for(int i=1;i<rows;i++) {
            //populate dp value for first column. this will get changed for every row
            dp[0] += matrix[i][0];
            for(int j=1;j<cols;j++){
                //dp[j-1] is left and dp[j] is top. so current dp[j] is sum of matrix value at that index +
                //minimum of left and top dp value
                dp[j] = matrix[i][j] + Math.min(dp[j-1],dp[j]);
            }
        }
        return dp[cols -1];
    }

    public static int minPath2D(int[][] matrix){
        if(matrix == null || matrix.length ==0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = matrix[0][0];
        //populate first row
        for(int j=1; j<cols;j++){
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }
        for(int i=1; i<rows;i++){
            dp[i][0] += matrix[i][0];
            for(int j=1; j< cols; j++){
                dp[i][j]= matrix[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[rows-1][cols-1];
    }


    public static void main(String[] args) {
        int[][] matrix  = {
                {1,3,1},
                {1,5,1},
                {4,2,1},
        };
        System.out.println(minPath2D(matrix));
    }
}
