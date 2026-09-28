package AssessmentCodes;

import java.util.*;

public class StringSort {
    public static void main(String[] args) {
        String str = "tree";
        char[] charArray = str.toCharArray();
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : charArray) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        //  Using Priority Queue (Max Heap)
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(charCount.entrySet());

        // Using List Sorting
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(charCount.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        System.out.println(Arrays.toString(list.toArray()));

        Arrays.sort(charArray);
        String sortedArr = new String(charArray);
        System.out.println(sortedArr);
    }
}