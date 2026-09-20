
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

        // My Method 1
        // Map<Integer, String> anagrams = new HashMap<>();
        // for (String str : strs) {
        // char[] chars = str.toCharArray();
        // int n = 0;
        // for (char c : chars) {
        // n += c - '0';
        // }
        // if (anagrams.containsKey(n)) {
        // System.out.println(str + ";" + anagrams.get(n));
        // } else {
        // anagrams.put(n, str);
        // }
        // }

        // Optimal SOlution
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (!anagrams.containsKey(sortedStr)) {
                anagrams.put(sortedStr, new ArrayList<>());
            }
            anagrams.get(sortedStr).add(str);
        }
        System.out.println(anagrams.values());
    }
}
