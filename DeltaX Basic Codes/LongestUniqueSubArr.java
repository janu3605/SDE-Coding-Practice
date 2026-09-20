import java.util.*;

public class LongestUniqueSubArr {
    public static void main(String[] args) {

        String s = "Hello World with a unique characters";
        int len = LargestSubArr(s);
        System.out.println(len);
    }

    public static int LargestSubArr(String s) {
        int maxlen = 0;
        char[] sarr = s.toCharArray();
        int i = 0, j = 1;
        Set<Character> set = new HashSet<>();

        while (i < j && j < s.length()) {
            int len = 0;
            if (set.add(sarr[j])) {
                len = j - i + 1;
                j++;
            } else {
                len = 0;
                i = j;
            }
            maxlen = Math.max(maxlen, len);
            System.out.println(s.subSequence(i, j));
        }
        return maxlen;
    }
}
