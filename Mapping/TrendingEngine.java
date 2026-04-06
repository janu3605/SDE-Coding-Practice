
/**
 * MODEL: Top 'K' Elements (Heap + HashMap)
 * * PROBLEM: The Viral Product Tracker
 * You are building a dashboard for a major e-commerce site. You are given
 * a list of product IDs that were purchased in the last hour.
 * * Your task is to identify the `K` most frequently purchased products.
 * If two products have the same frequency, the one with the lower ID
 * value should come first.
 * * * INPUT:
 * - productIds (an array of integers)
 * - k (the number of top products to return)
 * * OUTPUT:
 * - A list of integers representing the top K most frequent IDs.
 * * EXAMPLE 1:
 * Input: productIds = [1, 1, 1, 2, 2, 3], k = 2
 * Output: [1, 2]
 * Explanation: 1 appears three times, 2 appears twice.
 * * EXAMPLE 2:
 * Input: productIds = [1], k = 1
 * Output: [1]
 */
import java.util.*;

public class TrendingEngine {

    public static List<Integer> topKProducts(int[] productIds, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int id : productIds) {
            map.put(id, map.getOrDefault(id, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((id1, id2) -> {
            int freq1 = map.get(id1);
            int freq2 = map.get(id2);

            if (freq1 == freq2) {
                return id2 - id1;
            }
            return freq1 - freq2;
        });

        for (int id : map.keySet()) {
            minHeap.add(id);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> topK = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            topK.add(minHeap.poll());
        }

        Collections.reverse(topK);

        return topK;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] productIds = Arrays.stream(sc.nextLine().split(", "))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = sc.nextInt();
        System.out.println(topKProducts(productIds, k));
    }
}
