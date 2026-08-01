package BasicCoding;

import java.util.Arrays;

public class ArrayRotation {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int k = 2;
        k = k % array.length;
        rotate(array, k);
    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr, int a, int b) {
        while (a < b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a++;
            b--;
        }
    }
}
