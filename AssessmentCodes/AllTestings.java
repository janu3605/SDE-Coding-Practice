package AssessmentCodes;

import java.util.*;

public class AllTestings {
    public static void main(String[] args) {
        String str = "hello duh";

        int[] freq = new int[128];
        for (char c : str.toCharArray()) {
            freq[c]++;
        }
        // System.out.println(Arrays.toString(freq));

        Character[] chars = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }

        Arrays.sort(chars, (a, b) -> {
            int counta = freq[a];
            int countb = freq[b];
            if (counta != countb) {
                return Integer.compare(counta, countb);
            } else {
                return Character.compare(a, b);
            }
        });

        System.out.println(Arrays.toString(chars));
    }
}