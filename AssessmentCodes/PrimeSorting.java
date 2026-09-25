package AssessmentCodes;

import java.util.Arrays;

public class PrimeSorting {
    public static void main(String[] args) {
        Integer[] books = { 23, 14, 257, 52, 44 };

        Arrays.sort(books, (a, b) -> {
            int countA = PrimeCount(a);
            int countB = PrimeCount(b);

            if (countA != countB) {
                return Integer.compare(countA, countB);
            }
            else {
                return Integer.compare(a, b);
            }
        });

    }

    public static int PrimeCount(int n) {
        int count = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 2 || digit == 3 || digit == 5 || digit == 7) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}
