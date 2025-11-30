package collection;

import java.util.Stack;

public class LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights){
        int n = heights.length;
        int maxArea = 0;
        //monotonous stack implementation to keep increasing bars
        Stack<Integer> stack = new Stack<>();
        /**
         * - Use a stack to maintain increasing heights.
         * - When you see a bar shorter than the stack’s top:
         * - Pop from the stack.
         * - Compute area using the popped height as the limiting height.
         * - Width = distance between current index and the new stack top.
         * - Push current index onto stack.
         * - At the end, process remaining bars.
         * 👉 This ensures each bar is pushed and popped once → O(n).
         *
         *
         * 🚀 Complexity
         * - Time: O(n) → each bar pushed/popped once.
         * - Space: O(n) → stack.
         *
         * ⚡ Takeaway
         * - This problem is about finding boundaries efficiently.
         * - The monotonic stack is the key pattern — it shows up in many problems (Next Greater Element,
         * Daily Temperatures, etc.).
         * - It’s a must-master technique for hard-level interviews.
         *
         *
         * **/

        for(int i=0; i <= n; i++) {
            //height of current histogram bar
            int h = i==n ? 0 : heights[i];
            //while height of the bar's is greater than current element, pop it from stack and calculate max area
            while (!stack.empty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.empty() ? i : i - stack.peek() -1;
                maxArea = Math.max(maxArea, height*width);
            }
            //put index of bar
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,7,2,4};
        //7, 12, 15
        System.out.println(largestRectangleArea(heights)); // 15
    }

}
