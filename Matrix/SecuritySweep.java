package Matrix;

/**
 * MODEL: 2D Array / Simulation * PROBLEM: The Security Camera Sweep You are
 * designing software for a high-security warehouse. The warehouse is
 * represented by an M x N grid. Some cells contain valuable "Crates", while
 * others are empty. * A security robot starts at the top-left corner (0, 0) and
 * must visit every cell in a "Spiral" pattern to ensure total coverage: 1. Move
 * right across the top row. 2. Move down the rightmost column. 3. Move left
 * across the bottom row. 4. Move up the leftmost column. 5. Repeat the process
 * for the inner remaining grid until all cells are visited. * Your task is to
 * return a list of all elements in the order the robot visits them. * * INPUT:
 * - matrix (a 2D array of integers) * OUTPUT: - A List of integers representing
 * the spiral order. * EXAMPLE 1: Input: matrix = [ [1, 2, 3], [4, 5, 6], [7, 8,
 * 9] ] Output: [1, 2, 3, 6, 9, 8, 7, 4, 5] * EXAMPLE 2: Input: matrix = [ [1,
 * 2], [3, 4] ] Output: [1, 2, 4, 3]
 */
import java.util.*;

public class SecuritySweep {

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                list.add(matrix[j][right]);
            }
            right--;
            if (top <= bottom) {

                for (int j = right; j >= left; j--) {
                    list.add(matrix[bottom][j]);
                }
                bottom--;
            }
            if (left <= right) {

                for (int j = bottom; j >= top; j--) {
                    list.add(matrix[j][left]);
                }
                left++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }
}
