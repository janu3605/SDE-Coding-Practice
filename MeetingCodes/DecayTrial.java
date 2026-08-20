package MeetingCodes;

import java.util.*;

public class DecayTrial {

    private static final int[] dRow = { -1, 1, 0, 0 };
    private static final int[] dCol = { 0, 0, -1, 1 };

    private static int[][] grid;
    private static int[][] memo;
    private static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int X = sc.nextInt();
        int Y = sc.nextInt();

        memo = new int[N][M];

        System.out.println(dfs(X, Y));
    }

    private static int dfs(int r, int c) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        int maxLen = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dRow[i];
            int nc = c + dCol[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M && grid[nr][nc] < grid[r][c]) {
                maxLen = Math.max(maxLen, 1 + dfs(nr, nc));
            }
        }
        memo[r][c] = maxLen;
        return maxLen;
    }
}