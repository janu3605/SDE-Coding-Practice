import java.util.*;

public class StringFreqSort {

    public static void main(String s) {
        // 1. Count frequencies (acts like your PrimeCount method)
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        // 2. Convert to Object array because primitive char[] can't use a Comparator
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        // 3. Sort using Arrays.sort, EXACTLY like your example
        Arrays.sort(chars, (a, b) -> {
            int countA = freq[a];
            int countB = freq[b];

            if (countA != countB) {
                // Sort by frequency (descending: b compared to a)
                return Integer.compare(countB, countA);
            } else {
                // Tie-breaker: sort alphabetically
                return Character.compare(a, b);
            }
        });

        // 4. Convert back to string
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            result.append(c);
        }

        System.out.println(result.toString());
    }
}