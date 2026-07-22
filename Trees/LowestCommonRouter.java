// Scenario: In a hierarchical network topology (represented as a binary tree), two endpoint devices need to establish a secure tunnel. To optimize traffic, the connection should be handled by the lowest possible router that is a parent to both devices.
// Problem: Given a binary tree representing the network, find the lowest common ancestor (LCA) node of two given target nodes p and q.
// Input: root = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is the root node 3.
// Concepts Tested: Binary tree traversal, recursion, tree depth understanding.
package Trees;

public class LowestCommonRouter {

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        int p = 5;
        int q = 1;
        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p + " and " + q + " is: " + (lca != null ? lca.val : "null"));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (root.val == p || root.val == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
