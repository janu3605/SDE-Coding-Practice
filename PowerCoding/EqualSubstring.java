package PowerCoding;

import java.util.*;

public class EqualSubstring {
//  Find total contiguous substrings contasining equal 0 and 1.

    public static void main(String[] args) {
        String s = "0101";

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);

        for (char c : s.toCharArray()) {
            if (c == '1') {
                sum += 1;
            }
            if (c == '0') {
                sum -= 1;
            }
            System.out.println(map);
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }
}
