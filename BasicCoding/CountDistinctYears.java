// package BasicCoding;

public class CountDistinctYears {

    public static void main(String[] args) {
        String str = "UN was established on 24-10-1945 , with India getting freedom on 15-08-1947.";

        String[] words = str.split(" ");

        for (String word : words) {
            if (word.matches(".*\\d{2}-\\d{2}-\\d{4}.*")) { // Exact format
                // If using ".*\\d{2}-\\d{2}-\\d{4}.*" accepts any atttached values, eg:
                // 15-08-1945. (Full stop).
                System.out.println(word);
            }
        }
    }
}
