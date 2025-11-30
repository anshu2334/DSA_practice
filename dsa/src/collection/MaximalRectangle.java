package collection;

import java.util.Stack;

public class MaximalRectangle {
    public static int maximalRectArea(char[][] matrix){
        /**
         *
         * - Treat each row as the base of a histogram:
         * - For each column, compute the height of consecutive 1s up to that row.
         * - At each row, apply the Largest Rectangle in Histogram algorithm (LeetCode 84).
         * - Keep track of the maximum area across all rows.
         * **/
        if(matrix.length == 0) return 0;
        int n = matrix[0].length;
        int maxArea = 0;
        int[] heights = new int[n];
        for(char[] row: matrix) {
            for(int i=0; i< n; i++){
                if(row[i] == '1'){
                    heights[i] +=1;
                }else {
                    heights[i] = 0;
                }
            }

            maxArea = Math.max(maxArea,largestAreaHistogram(heights));
        }
        return  maxArea;
    }

    public static int largestAreaHistogram(int[] heights) {

        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<= n; i++) {
            int h = i==n ? 0 : heights[i];
            while(!stack.empty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.empty() ? i : i -stack.peek() -1;
                maxArea = Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        return  maxArea;
    }



    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectArea(matrix)); // 6
    }

}
