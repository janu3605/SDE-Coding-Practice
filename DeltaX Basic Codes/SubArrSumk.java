public class SubArrSumk {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 9;
        int count = 0;

        int sum = 0;
        int left = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            while (sum > k && left <= i) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                count++;
            }
        }
        System.out.println(count);

    }
}
