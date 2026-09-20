import java.util.*;

public class TopKfreq {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 2, 3, 5, 4, 6, 4, 3, 3 };
        int k = 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.putIfAbsent(num, 1);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[] { entry.getValue(), entry.getKey() });
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.poll()[1] + " ");
        }
    }
}
