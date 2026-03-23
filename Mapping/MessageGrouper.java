
/**
 * MODEL: Hash Table / Frequency Counting
 * * PROBLEM: The Integrity Check (Anagram Groups)
 * You are working for a cybersecurity firm. You have intercepted a large
 * batch of encrypted messages. Your team has discovered that messages
 * containing the exact same characters in different orders (anagrams)
 * belong to the same source.
 * * Your task is to group these messages together so the analysts can
 * identify the primary sources of the communication.
 * * * INPUT:
 * - messages (an array of Strings)
 * * OUTPUT:
 * - A List of Lists, where each sub-list contains all strings that
 * are anagrams of each other. The order of the groups doesn't matter.
 * * EXAMPLE 1:
 * Input: messages = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * * EXAMPLE 2:
 * Input: messages = [""]
 * Output: [[""]]
 */
import java.util.*;

public class MessageGrouper {

    public static List<List<String>> groupMessages(String[] messages) {
        Map<String, List<String>> map = new HashMap<>();

        for (String message : messages) {
            char[] c = message.toCharArray();
            Arrays.sort(c);
            String word = Arrays.toString(c);
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(message);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inpt = sc.nextLine().split(", ");
        List<List<String>> res = groupMessages(inpt);
        System.out.println(res.toString());
    }
}
