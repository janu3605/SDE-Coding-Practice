import java.util.*;

public class KthLargest {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 8, 3, 7, 4, 9 };
        int k = 3;

        //Arrays.sort(arr, Collections.reverseOrder());
        

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println(pq.peek());
    }
}
