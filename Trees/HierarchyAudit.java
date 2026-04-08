package Trees;

/**
 * MODEL: Tree Depth-First Search (DFS) / Recursion * PROBLEM: The Maximum Span
 * of Authority You are auditing a corporate hierarchy represented as a Binary
 * Tree, where each node is an employee. You need to find the "Maximum Depth" of
 * this tree, which represents the longest chain of command from the CEO (root)
 * down to the lowest-level intern (leaf). * A leaf node is an employee who has
 * no direct reports (no children). * * INPUT: - root (The root node of the
 * binary tree) * OUTPUT: - An integer representing the maximum depth. * EXAMPLE
 * 1: Input: root = [3, 9, 20, null, null, 15, 7] Output: 3 Explanation: The
 * longest path is 3 -> 20 -> 15 (or 7), which is 3 nodes deep. * EXAMPLE 2:
 * Input: root = [1, null, 2] Output: 2
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//  Not Manually Solved. 

public class HierarchyAudit {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Maximum Depth of Example 1: " + maxDepth(root1));
    }
}
