
import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        String str = "13[a]2[bc]";
        //  1. Using StringBuilder and repeat method
        // for (int i = 0; i < str.length(); i++) {
        //     if (Character.isDigit(str.charAt(i))) {
        //         int n = Character.getNumericValue(str.charAt(i));
        //         if (str.charAt(i + 1) == '[') {
        //             StringBuilder sb = new StringBuilder();
        //             int j = i + 2;
        //             while (str.charAt(j) != ']') {
        //                 sb.append(str.charAt(j));
        //                 j++;
        //             }
        //             String repeatedString = sb.toString().repeat(n);
        //             System.out.print(repeatedString);
        //             i = j;
        //         }
        //     }
        // }
        // 2. Using Stacks
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString.toString());
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = new StringBuilder(stringStack.pop());
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        System.out.println(currentString.toString());
    }
}
