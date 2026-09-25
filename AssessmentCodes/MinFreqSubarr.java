package AssessmentCodes;

// This problem can be solved by finding the first occurrence and last occurrence of the character And that will be the length of the substance that needs to be formed for that exact character count .So checking for the min Of such can result to the answer.
public class MinFreqSubarr {
    public static void main(String[] args) {
        String S = "abcadbcd";
        int minLength = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int firstIndex = S.indexOf(c);
            int lastIndex = S.lastIndexOf(c);
            if (firstIndex != -1) {
                int length = lastIndex - firstIndex + 1;
                minLength = Math.min(minLength, length);
            }
        }
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}