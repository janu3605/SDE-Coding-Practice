package PowerCoding;

import java.util.*;

public class BalancedCharSubstring {
    public static void main(String[] args) {
        String str = "AABCXAB";
        int n = str.length();
        int match = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int Acount = 0;
        int Bcount = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'A') {
                Acount++;
            } else if (str.charAt(i) == 'B') {
                Bcount++;
            }
            // else if (str.charAt(i) == 'C') {
            // continue;
            // }
            else if (str.charAt(i) == 'X') {
                Acount = 0;
                Bcount = 0;
                map.clear();
                map.put(0, 1);
            }
            int diff = Acount - Bcount;
            if (map.containsKey(diff)) {
                match += 1;
            }
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        System.out.println("Balanced Substrings: " + match);
    }
}
