
import java.util.Arrays;
import java.util.Scanner;

/**
 * MODEL: Greedy Algorithm * PROBLEM: The Last Mile Delivery You are programming
 * a delivery drone that travels across a straight line of charging pads. Each
 * integer in the array represents the MAXIMUM number of pads the drone can jump
 * forward from that current position based on its current battery charge. * You
 * start at the first pad (index 0). Your goal is to determine if the drone can
 * successfully reach the last pad in the array. * * INPUT: - batteryCharges (an
 * array of integers) * OUTPUT: - A boolean: true if you can reach the last
 * index, false otherwise. * EXAMPLE 1: Input: batteryCharges = [2, 3, 1, 1, 4]
 * Output: true Explanation: Jump 1 step from index 0 to 1, then 3 steps to the
 * last pad. * EXAMPLE 2: Input: batteryCharges = [3, 2, 1, 0, 4] Output: false
 * Explanation: You will always arrive at index 3, but its jump limit is 0,
 * making it impossible to reach the end.
 */
public class DroneNavigator {

    public static boolean canReachEnd(int[] batteryCharges) {
        int furthestReach = 0; // the absolute maximum index we have enough power to reach

        for (int i = 0; i < batteryCharges.length; i++) {

            // if our current position is further than our maximum allowed reach, 
            // it means we got stranded at a 0 battery pad earlier!
            if (i > furthestReach) {
                return false;
            }

            // push the boundary! 
            // is our current boundary better, or is the (current index + battery here) better?
            furthestReach = Math.max(furthestReach, i + batteryCharges[i]);

            // optional optimization: if our boundary is already past the end, we win early.
            if (furthestReach >= batteryCharges.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inpt = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(canReachEnd(inpt));
    }
}
