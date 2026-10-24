import java.util.*;

public class StringFreqSort {

    public static void main(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        Arrays.sort(chars, (a, b) -> {
            int countA = freq[a];
            int countB = freq[b];

            if (countA != countB) {
                return Integer.compare(countB, countA);
            } else {
                return Character.compare(a, b);
            }
        });

        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            result.append(c);
        }

        System.out.println(result.toString());
    }
}