
public class PeakElement {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 20, 4, 5, 0 };
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                System.out.println(arr[i]);
            }
        }
    }
}
