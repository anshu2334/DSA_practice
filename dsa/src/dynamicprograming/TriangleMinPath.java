package dynamicprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleMinPath {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // Start from second last row
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                int down = triangle.get(i+1).get(j);
                int diag = triangle.get(i+1).get(j+1);
                rows.set(j, rows.get(j) + Math.min(down, diag));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer>row1 = new ArrayList<>();
        row1.add(2);
        triangle.add(row1);

        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        triangle.add(row2);

        List<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        triangle.add(row3);

        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        triangle.add(row4);

        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(Arrays.asList(2));
        triangle1.add(Arrays.asList(3, 4));
        triangle1.add(Arrays.asList(6, 5, 7));
        triangle1.add(Arrays.asList(4, 1, 8, 3));

        printTriangle(triangle1);

        System.out.println(minimumTotal(triangle1));
    }

    public static void printTriangle(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Step 1: Find max number length
        int maxLen = 0;
        for (List<Integer> row : triangle) {
            for (int num : row) {
                maxLen = Math.max(maxLen, String.valueOf(num).length());
            }
        }

        // Step 2: Print row by row
        for (int i = 0; i < n; i++) {
            // Leading spaces for alignment
            for (int s = 0; s < n - i - 1; s++) {
                System.out.print(" ".repeat(maxLen + 1));
            }

            // Print row elements with fixed width
            for (int j = 0; j < triangle.get(i).size(); j++) {
                System.out.printf("%" + maxLen + "d ", triangle.get(i).get(j));
            }
            System.out.println();
        }
    }

}
