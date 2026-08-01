package BasicCoding;

public class ReverseWords {

    public static void main(String[] args) {
        String[] words = {"Hello", "world"};
        Reverse(words);
    }
    // 1. StringBuilder
    // public static void Reverse(String[] words) {
    //     StringBuilder sb = new StringBuilder();

    //     for (String str : words) {
    //         String word = new StringBuilder(str).reverse().toString();
    //         sb.append(word + " ");
    //     }
    //     System.out.println(sb.toString());
    // }
    // 2. Character Array 2 pointer
    // public static String reverseWords(String sentence) {
    //     if (sentence == null || sentence.isEmpty()) return sentence;
    //     char[] chars = sentence.toCharArray();
    //     int start = 0;
    //     for (int end = 0; end <= chars.length; end++) {
    //         // Reverse when reaching a space or the end of the string
    //         if (end == chars.length || chars[end] == ' ') {
    //             reverseCharArray(chars, start, end - 1);
    //             start = end + 1; // Move start pointer past the space
    //         }
    //     }
    //     return new String(chars);
    // }
    // // Helper method to swap characters between two indices
    // private static void reverseCharArray(char[] chars, int left, int right) {
    //     while (left < right) {
    //         char temp = chars[left];
    //         chars[left] = chars[right];
    //         chars[right] = temp;
    //         left++;
    //         right--;
    //     }
    // }
}
