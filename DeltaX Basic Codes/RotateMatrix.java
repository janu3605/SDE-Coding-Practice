// to Rotate 90 degrees

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int n = 3;
        /*
         * 7 4 1
         * 8 5 2
         * 9 6 3
         */
        // Essentially columns become rows and rows become columns.
        // First row bcms last column ... reverse row order into columns.

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] rows = new int[n];

            for (int j = 0; j < n; j++) {
                rows[j] = matrix[n - 1 - j][i];
            }
            result[i] = rows;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Optimal Method: Inplace rotation of matrix O(n^2) time and O(1) space
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            // Start j from i to only swap the top right triangle with the bottom left
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

}
