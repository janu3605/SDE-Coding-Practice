package AssessmentCodes;
// In this qn

//  If one swap first N by 2 and last N by two characters of string

public class StrSwapModification {
    public static void main(String[] args) {
        String str = "Hello World";
        char[] charArray = str.toCharArray();
        int[] ops = { 0, 1, 1, 1 };
        for (int op : ops) {
            if (op == 0) {
                easySwap(charArray);
            } else if (op == 1) {
                hardSwap(charArray);
            }
        }

        System.out.println(new String(charArray));
    }

    public static void easySwap(char[] charArray) {
        // Swap first and last characters
        char temp = charArray[0];
        charArray[0] = charArray[charArray.length - 1];
        charArray[charArray.length - 1] = temp;
    }

    public static void hardSwap(char[] charArray) {
        // Swap first N/2 and last N/2 characters
        int n = charArray.length;
        int half = n / 2;
        for (int i = 0; i < half; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[n - 1 - i];
            charArray[n - 1 - i] = temp;
        }
    }
}
