package AssessmentCodes;
/*
Water Pipe Cost ManagementA municipal corporation manages a network of water supply pipes connecting $N$ towns in a tree structure ($N$ towns, $N-1$ bidirectional pipes). Each pipe has a specific maintenance cost.

You are given:N (number of towns, 1-indexed)edges ($N-1$ initial pipes, where each pipe is represented as [u, v, cost])queries ($Q$ queries, where each query is represented as [type, u, v, cost])

Query Operations:
Type 1 (1, u, v, 0): Calculate the total maintenance cost along the unique simple path between town u and town v.
Type 2 (2, u, v, new_cost): Update the maintenance cost of the direct pipe between town u and town v to new_cost.Goal: Return the sum of costs obtained across all Type 1 queries (or an array of outputs for each Type 1 query).
*/
import java.util.*;

public class WaterPipeCostManagement {

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static long processWaterPipeQueries(int N, int[][] edges, int[][] queries) {
        // Build adjacency list for the tree graph
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], cost = e[2];
            adj.get(u).add(new Edge(v, cost));
            adj.get(v).add(new Edge(u, cost));
        }

        long totalCostSum = 0;

        for (int[] q : queries) {
            int type = q[0];
            int u = q[1];
            int v = q[2];
            int cost = q[3];

            if (type == 1) {
                // Type 1: Calculate total cost along path between u and v
                long pathCost = getPathCost(u, v, -1, adj);
                totalCostSum += pathCost;
            } else if (type == 2) {
                // Type 2: Update edge cost between u and v
                updateEdgeCost(u, v, cost, adj);
                updateEdgeCost(v, u, cost, adj);
            }
        }

        return totalCostSum;
    }

    // DFS to find the unique path between 'curr' and 'target' and return path cost
    private static long getPathCost(int curr, int target, int parent, List<List<Edge>> adj) {
        if (curr == target) {
            return 0; // Reached target
        }

        for (Edge edge : adj.get(curr)) {
            if (edge.to != parent) {
                long res = getPathCost(edge.to, target, curr, adj);
                if (res != -1) {
                    return res + edge.cost; // Add edge cost on the active path
                }
            }
        }

        return -1; // Target not reachable through this branch
    }

    // Helper method to update the weight of an edge in the adjacency list
    private static void updateEdgeCost(int u, int v, int newCost, List<List<Edge>> adj) {
        for (Edge edge : adj.get(u)) {
            if (edge.to == v) {
                edge.cost = newCost;
                break;
            }
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] edges = {
                { 1, 2, 10 },
                { 1, 3, 20 },
                { 2, 4, 15 },
                { 2, 5, 5 }
        };

        int[][] queries = {
                { 1, 4, 3, 0 }, // Query path 4 -> 2 -> 1 -> 3 (15 + 10 + 20 = 45)
                { 2, 1, 2, 25 }, // Update edge (1-2) cost from 10 to 25
                { 1, 4, 3, 0 } // Query path 4 -> 2 -> 1 -> 3 (15 + 25 + 20 = 60)
        };

        long result = processWaterPipeQueries(N, edges, queries);
        System.out.println("Total Cost Across All Type 1 Queries: " + result); // Output: 105
    }
}