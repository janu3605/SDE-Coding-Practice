import java.util.*;

public class StringSort {
    public static void main(String[] args) {
        String str = "tree";
        char[] charArray = str.toCharArray();
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : charArray) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(charCount.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        System.out.println(Arrays.toString(list.toArray()));
        

        Arrays.sort(charArray);
        String sortedArr = new String(charArray);
        System.out.println(sortedArr);
    }
}