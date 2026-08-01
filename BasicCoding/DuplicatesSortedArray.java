package BasicCoding;

import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicatesSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};
        // int[] res = removeDuplicates(arr);
        removeDuplicates(arr);
        // System.out.println(Arrays.toString(res));
    }
// 1.ArrayList
    // public static int[] removeDuplicates(int[] arr) {
    //     ArrayList<Integer> res = new ArrayList<>();
    //     for (int i = 0; i < arr.length; i++) {
    //         if (i == 0) {
    //             res.add(arr[i]);
    //         } else if (res.get(res.size() - 1) != arr[i]) {
    //             res.add(arr[i]);
    //         }
    //     }
    //     int[] ans = res.stream().mapToInt(Integer::intValue).toArray();
    //     return ans;
    // }

    // 2. LinkedHashSet
    public static void removeDuplicates(int[] arr) {
        Set<Integer> ans = new LinkedHashSet<>();
        for (int i : arr) {
            ans.add(i);
        }
        System.out.println(ans.toString());
    }

}
