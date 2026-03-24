
/**
 * MODEL: Fast and Slow Pointers
 * * PROBLEM: The Power Grid Short Circuit
 * You are an engineer on a deep space station. The power nodes are connected
 * in a unidirectional chain. However, a recent micrometeoroid strike might have
 * caused a short circuit, creating a closed loop in the power grid.
 * * A loop means the power gets trapped and overloads the system. You need to
 * verify if the sequence of power nodes contains a cycle.
 * * Your task is to process the starting node and return true if there is a loop,
 * or false if the power safely reaches the end of the line.
 * * * INPUT:
 * - head (the starting ListNode of the power grid)
 * * OUTPUT:
 * - A boolean representing whether a cycle exists.
 * * EXAMPLE 1:
 * Input: head = [3, 2, 0, -4], pos = 1 (node -4 connects back to node 2)
 * Output: true
 * Explanation: There is a cycle in the power grid, where the tail connects to the 1st node.
 * * EXAMPLE 2:
 * Input: head = [1, 2]
 * Output: false
 * Explanation: The grid ends safely without looping back.
 */
import java.util.*;

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class PowerGrid {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter grid nodes (e.g., 3, 2, 0, -4):");
        String inputLine = sc.nextLine();
        if (inputLine.isEmpty()) {
            return;
        }

        int[] inpt = Arrays.stream(inputLine.split(", ")).mapToInt(Integer::parseInt).toArray();

        System.out.println("enter cycle position index (-1 for no cycle):");
        int pos = sc.nextInt();

        // 1. initialize the head with the first number
        ListNode head = new ListNode(inpt[0]);
        ListNode current = head; // our builder pointer
        ListNode cycleTarget = null; // remembers where the loop should connect

        // check if the very first node is the cycle target
        if (pos == 0) {
            cycleTarget = head;
        }

        // 2. build the rest of the list
        for (int i = 1; i < inpt.length; i++) {
            current.next = new ListNode(inpt[i]); // attach a new node
            current = current.next;               // move the builder forward

            // if we reach the index where the cycle should happen, remember this node!
            if (i == pos) {
                cycleTarget = current;
            }
        }

        // 3. create the short circuit (the loop)
        if (pos != -1) {
            current.next = cycleTarget; // tail points back to the target
        }

        // test it out
        System.out.println("cycle detected: " + hasCycle(head));

        sc.close();
    }
}
