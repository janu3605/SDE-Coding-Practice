package StacksUsage;

// Scenario: Data packets sent over a network use specific brackets to define header boundaries. A corrupted packet will have mismatched or unclosed boundaries, which can crash the router if processed.
// Problem: Given a string packet_data containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. It is valid if open brackets are closed by the same type of brackets, and in the correct order.
// Input: packet_data = "{[()]}"
// Output: true
// Input: packet_data = "([)]"
// Output: false
// Concepts Tested: Stack data structure, string parsing, LIFO execution.
import java.util.*;

public class PacketHeaderValidation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String packet_data = sc.nextLine();
        System.out.println(isValid(packet_data));
        sc.close();
    }

    public static boolean isValid(String packet_data) {
        Stack<Character> stack = new Stack<>();
        for (char c : packet_data.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.add(c);
            }

            switch (c) {
                case ')':
                    if (stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.pop() != '[') {
                        return false;
                    }
                    break;

                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
}
