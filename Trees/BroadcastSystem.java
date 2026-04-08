package Trees;

/**
 * MODEL: Tree Breadth-First Search (BFS) / Level-Order Traversal * PROBLEM: The
 * Level-by-Level Alert You are designing a communication protocol for a network
 * of servers arranged in a binary tree. When an alert is issued, it spreads
 * level by level. You need to capture the server IDs at each level separately
 * so the system can log the order of the broadcast. * * INPUT: - root (The root
 * node of the binary tree) * OUTPUT: - A List of Lists, where each sub-list
 * contains IDs of servers at that level. * EXAMPLE 1: Input: root = [3, 9, 20,
 * null, null, 15, 7] Output: [[3], [9, 20], [15, 7]] * EXAMPLE 2: Input: root =
 * [1] Output: [[1]]
 */
import java.util.*;
//  Not Manually Solved. 

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BroadcastSystem {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // edge case: if the tree is completely empty, return the empty list
        if (root == null) {
            return result;
        }

        // a Queue is perfect for BFS because it's First-In, First-Out (FIFO)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // MAGIC STEP: lock in the number of nodes on the current level
            int levelSize = queue.size();

            // a temporary list just to hold the values for this specific level
            List<Integer> currentLevel = new ArrayList<>();

            // process exactly 'levelSize' nodes, no more, no less
            for (int i = 0; i < levelSize; i++) {
                // pop the front node off the queue
                TreeNode currentNode = queue.poll();

                // record its value
                currentLevel.add(currentNode.val);

                // queue up its children for the NEXT level
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // the level is finished, so save it to our final result
            result.add(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Build the tree: [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> levels = levelOrder(root);
        System.out.println(levels);
    }
}
