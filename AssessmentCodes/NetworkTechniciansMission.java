package AssessmentCodes;

import java.util.*;

/*
Network Technician's MissionIn the city of Techville, a network technician named Sam is tasked with inspecting a newly established network of $N$ communication towers structured as a rooted tree (with the main control tower at node 1).Each tower is located in either a safe zone or a hazardous (unsafe) zone. The outermost towers (the leaf nodes) need to be inspected. Sam wants to find the total number of leaf nodes he can reach safely without traversing through more than $M$ consecutive hazardous zones along the path from node 1 to that leaf node.
 */
public class NetworkTechniciansMission {

    public static int safeViewPoints(int N, int M, int[] status, int[][] edges) {
        // Build adjacency list for the tree (1-indexed nodes)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        System.out.println(adj);

        return dfs(1, 0, 0, M, status, adj);
    }

    private static int dfs(int node, int parent, int consecutiveHaz, int M, int[] status, List<List<Integer>> adj) {
        // Update consecutive hazardous count (Assuming status[node-1] == 1 means
        // hazardous)
        if (status[node - 1] == 1) {
            consecutiveHaz++;
        } else {
            consecutiveHaz = 0; // Reset on safe node
        }

        // If consecutive hazardous nodes exceed M, prune this path
        if (consecutiveHaz > M) {
            return 0;
        }

        boolean isLeaf = true;
        int safeLeafCount = 0;

        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                isLeaf = false; // Has at least one child node
                safeLeafCount += dfs(neighbor, node, consecutiveHaz, M, status, adj);
            }
        }

        // Base Case: If it's a leaf node and valid, return 1
        if (isLeaf && node != 1) {
            return 1;
        }

        return safeLeafCount;
    }

    public static void main(String[] args) {
        int N = 7;
        int M = 1;
        // 1 = hazardous, 0 = safe
        int[] status = { 0, 1, 0, 0, 1, 1, 1 };
        int[][] edges = {
                { 1, 2 }, { 1, 3 },
                { 2, 4 }, { 2, 5 },
                { 3, 6 }, { 3, 7 }
        };

        System.out.println("Valid Leaf Count: " + safeViewPoints(N, M, status, edges)); // Output: 3
    }
}