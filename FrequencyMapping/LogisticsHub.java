
/**
 * MODEL: Frequency Mapping & Custom Sorting
 * * PROBLEM: The Logistics Hub Sorting
 * You are working for a global logistics company. A shipping container has arrived at the hub
 * containing various packages, each labeled with a specific Category ID (integer). Due to a
 * system glitch, the packages are all mixed up.
 * * To optimize the automated sorting robots, you need to reorganize the packages based on frequency:
 * 1. Packages that appear less frequently in the container must be sent to the sorting line first.
 * 2. If two different categories appear the same number of times, the category with the larger
 * ID value must be sent first.
 * * * INPUT:
 * - packages (array of integers representing Category IDs)
 * * OUTPUT:
 * - Return an array of integers representing the sorted packages.
 * * EXAMPLE:
 * Input: packages = [4, 4, 6, 2, 2, 2, 8, 8]
 * Output: [6, 8, 8, 4, 4, 2, 2, 2]
 */
import java.util.*;

public class LogisticsHub {

    public static int[] sortPackages(int[] packages) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int ele : packages) {
            frequency.put(ele, frequency.getOrDefault(ele, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int ele : packages) {
            list.add(ele);
        }

        Collections.sort(list, (a, b) -> {
            int freqA = frequency.get(a);
            int freqB = frequency.get(b);

            if (freqA != freqB) {
                return freqA - freqB;
            } else {
                return b - a;
            }
        });

        int[] result = new int[packages.length];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] packages = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(sortPackages(packages)));
        sc.close();
    }
}
