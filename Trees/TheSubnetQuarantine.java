// You are building an automated incident response tool for an enterprise cybersecurity dashboard. The company's internal server network is strictly routed as a Binary Search Tree (BST), where each node represents a server's unique internal IP address (represented as an integer for simplicity).
// The security system has flagged two specific servers, Server A and Server B, for suspicious activity. To prevent the threat from spreading while minimizing disruption to the rest of the network, you need to find the lowest common ancestor (LCA) server that routes to both of them. By quarantining this specific ancestor node, you isolate the compromised subnet.
// Given the root of the BST and the two target nodes p and q (which are guaranteed to exist in the tree), return the lowest common ancestor node.
package Trees;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class SecurityDashboard {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) {
            return null;
        }
        if 


        return null;
    }
}
