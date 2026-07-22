package DynamicProgramming;

import java.util.*;

public class CargoRoute {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println("Grid: " + Arrays.deepToString(grid));
    }

    public int calcMin(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        if (grid[m - 1][n - 1] < 0) {
            dp[m - 1][n - 1] = Math.abs(grid[m - 1][n - 1]) + 1;
        }else{
            dp[m - 1][n - 1] = 1;
        }

        

    }
}
