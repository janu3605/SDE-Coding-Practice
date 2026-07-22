// 4. Cell Tower Connectivity (Graphs / BFS or DFS)Scenario: Nokia is mapping out a grid of cell towers. Some towers are directly connected by physical fiber, while others are connected indirectly through a chain of other towers. A group of connected towers forms a "network cluster."Problem: There are n towers numbered from 0 to n - 1. You are given an n x n matrix is_connected where is_connected[i][j] == 1 if the $i^{th}$ tower and the $j^{th}$ tower are directly connected, and 0 otherwise. Return the total number of independent network clusters.Input: is_connected = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]Output: 2Explanation: Towers 0 and 1 are connected to each other, forming one cluster. Tower 2 is isolated, forming a second cluster.Concepts Tested: Graph traversal (DFS/BFS), identifying connected components, matrix manipulation.

import java.util.*;

public class CellTowerConnectivity {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] is_connected = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                is_connected[i][j] = sc.nextInt();
            }
        }
        System.out.println(countClusters(is_connected));
        sc.close();
    }

    public static int countClusters(int[][] is_connected) {
        int n = is_connected.length;
        boolean[] visited = new boolean[n];
        int clusterCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(is_connected, visited, i);
                clusterCount++;
            }
        }
        return clusterCount;
    }

    public static void dfs(int[][] is_connected, boolean[] visited, int current) {
        visited[current] = true;
        for (int j = 0; j < is_connected.length; j++) {
            if (is_connected[current][j] == 1 && !visited[j]) {
                dfs(is_connected, visited, j);
            }
        }
    }
}
