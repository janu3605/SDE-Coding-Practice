package PowerCoding;

import java.util.HashMap;
import java.util.Map;

public class SpclDish {

    public static void main(String[] args) {

        String s = "123123";

        int totalWays = 0;

        int count1 = 0, count2 = 0, count3 = 0;

        Map<String, Integer> map = new HashMap<>();

        map.put("0#0", 1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                count1++;
            } else if (ch == '2') {
                count2++;
            } else if (ch == '3') {
                count3++;
            } else {
                count1 = 0;
                count2 = 0;
                count3 = 0;
                map.clear();
                map.put("0#0", 1);
                continue;
            }
            int diff12 = count1 - count2;
            int diff23 = count3 - count2;
            String key = diff12 + "#" + diff23;
            totalWays += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        System.out.println(totalWays); // Output: 3
    }
}
