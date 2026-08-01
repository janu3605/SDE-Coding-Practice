package BasicCoding;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] rev = reverse(arr);
        reverse();
        System.out.println(Arrays.toString(rev));
    }

    // 1. Using two pointers
    // public static int[] reverse(int[] arr) {
    //     int n = arr.length;
    //     int[] rev = new int[n];
    //     for (int i = n - 1; i >= 0; i--) {
    //         rev[n - 1 - i] = arr[i];
    //     }
    //     return rev;
    // }

    // 2. 2 Pointer inPlace
    public static int[] reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    // 3. Collections
    public static void reverse() {
        Integer[] arr = {1, 2, 3, 4, 5};
        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
    }
}
