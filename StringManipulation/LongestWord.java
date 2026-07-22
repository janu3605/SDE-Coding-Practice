import java.util.*;

public class LongestWord {

    public static void main(String[] args) {
        String[] input = new String[]{"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        int longestWord = findLongestEvenVowelWord(input);
        System.out.println("The longest word length is: " + longestWord);
    }

    static ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static int findLongestEvenVowelWord(String[] input) {
        int maxLen = 0;
        for (String word : input) {
            char ch = word.charAt(0);
            if (word.length() % 2 != 0 || !vowels.contains(ch)){
                continue;
            }else{
                maxLen = Math.max(word.length(), maxLen);
            }
        }

        return maxLen;
    }
}
