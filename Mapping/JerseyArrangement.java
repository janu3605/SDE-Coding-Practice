
import java.util.*;

public class JerseyArrangement {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 4};
        int n = arr.length;
        int[] res = {1, 2, 3, 4, 5};

        int ans = 0;
        while (true) {
            ans++;
            int[] next = new int[n];
            for (int i = 0; i < n; i++) {
                next[i] = res[arr[i] - 1];
            }
            res = next;
            int[] sorted = res.clone();
            Arrays.sort(sorted);
            if (Arrays.equals(res, sorted)) {
                System.out.println(ans);
                break;
            }
        }

    }
}
