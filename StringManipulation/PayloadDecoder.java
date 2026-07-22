// Scenario: To save bandwidth, text payloads sent across the network are compressed using a specific algorithm. A multiplier number is placed in front of brackets containing the string to be repeated. You need to write the parser that reconstructs the original string.
// Problem: Given an encoded string, return its decoded string. The encoding rule is k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer, and there may be nested brackets.

// Input: payload = "3[a2[c]]"
// Output: "accaccacc"
// Explanation: The inner string 2[c] decodes to "cc". That is then multiplied by 3 as 3[acc], resulting in "accaccacc".
// Input: payload = "2[nokia]3[5G]"
// Output: "nokianokia5G5G5G"
import java.util.Stack;

public class PayloadDecoder {

    public static String decodePayload(String payload) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (char ch : payload.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');

            } else if (ch == '[') {
                numStack.push(currentNum);
                strStack.push(currentString);

                currentString = new StringBuilder();
                currentNum = 0;

            } else if (ch == ']') {
                StringBuilder prevString = strStack.pop();
                int multiplier = numStack.pop();

                for (int i = 0; i < multiplier; i++) {
                    prevString.append(currentString);
                }

                currentString = prevString;

            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodePayload("3[a2[c]]")); // Output: accaccacc

    }
}
