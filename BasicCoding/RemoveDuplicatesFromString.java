package BasicCoding;

import java.util.*;

public class RemoveDuplicatesFromString {

    public static void main(String[] args) {
        String str = "Hello world";
        duplicate(str);
    }
// 1. HashSet and StringBuilder 

    public static void duplicate(String str) {
        Set<Character> check = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (check.add(c)) {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }

// 2. Java Stream

    // public static void duplicate(String str) {
    //     String res = str.chars().distinct().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
    //             .toString();
    //     System.out.println(res);
    // }
}
