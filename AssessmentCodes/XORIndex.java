package AssessmentCodes;

public class XORIndex {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        int totalXOR = 0;
        for (int val : arr) {
            totalXOR ^= val;
        }
        int leftXOR = 0;

        for (int i = 0; i < arr.length; i++) {
            int rightXOR = totalXOR ^ leftXOR ^ arr[i];

            if (leftXOR > rightXOR) {
                System.out.println(i);
            }

            leftXOR ^= arr[i];
        }
    }
}
