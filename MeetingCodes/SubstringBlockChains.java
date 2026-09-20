package MeetingCodes;

import java.util.*;

public class SubstringBlockChains {
    public static void main(String[] args) {
        String wall = "barfoothefoobarman";
        String[] blocks = { "foo", "bar" };

        int N = wall.length();
        int n = blocks.length;
        int l = blocks[0].length();
        int total = n * l;

        List<Integer> result = new ArrayList<>();

        Map<String, Integer> target = new HashMap<>();

        for (String b : blocks) {
            target.put(b, target.getOrDefault(b, 1) + 1);
        }
        for (int i = 0; i < N - total + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            for (int j = 0; j < total; j += l) {
                String word = wall.substring(i + j, i + j + l);
                seen.put(word, seen.getOrDefault(word, 1) + 1);
            }
            if (seen.equals(target)) {
                result.add(i);
            }
        }
        System.out.println(result.isEmpty() ? Arrays.asList(-1) : result);
    }
}
