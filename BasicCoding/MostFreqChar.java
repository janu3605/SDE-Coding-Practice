package BasicCoding;

public class MostFreqChar {

    public static void main(String[] args) {
        String str = "Hello World! This is a sample string to find the most frequent character.";

        int[] freq = new int[26];
        str = str.toLowerCase().replaceAll("[^a-z]", "");

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxFreq = 0;
        char mostFreqChar = ' ';

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                mostFreqChar = (char) (i + 'a');
            }
        }

        System.out.println("The most frequent character is: " + mostFreqChar + " with frequency: " + maxFreq);
    }
}
