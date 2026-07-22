// You are given two lowercase strings, $A$ and $B$, both of equal length $N$.  Your goal is to transform string $A$ into string $B$ using the minimum number of operations. If it is impossible to transform $A$ into $B$, return -1.

import java.util.HashSet;
import java.util.Set;

public class StringEquality {

    public static void main(String[] args) {
        String A = "abcab";
        String B = "aabab";

        int result = minOperations(A, B);
        System.out.println(result);
    }

    public static int minOperations(String A, String B) {
        int n = A.length();

        Set<Character> aChars = new HashSet<>();
        for (int i = 0; i < n; i++) {
            aChars.add(A.charAt(i));
        }

        Set<Character> neededInB = new HashSet<>();

        for (int i = 0; i < n; i++) {
            char charA = A.charAt(i);
            char charB = B.charAt(i);

            if (charA < charB) {
                return -1;
            }
            if (charA != charB) {
                if (!aChars.contains(charB)) {
                    return -1;
                }
                neededInB.add(charB);
            }
        }
        return neededInB.size();
    }

    // public static int minOperations(String A, String B) {
    //     char[] aChars = A.toCharArray();
    //     char[] bChars = B.toCharArray();
    //     int n = A.length();
    //     int operations = 0;
    //     ArrayList<Character> aRes = new ArrayList<>();
    //     ArrayList<Character> bRes = new ArrayList<>();
    //     for (int i = 0; i < n; i++) {
    //         if (aChars[i] != bChars[i]) {
    //             aRes.add(aChars[i]);
    //             bRes.add(bChars[i]);
    //         }
    //     }
    //     for (int i = 0; i < aRes.size(); i++) {
    //         boolean found = false;
    //         for (int j = 0; j < bRes.size(); j++) {
    //             if (aRes.get(i) == bRes.get(j)) {
    //                 found = true;
    //                 bRes.remove(j);
    //                 break;
    //             }
    //         }
    //         if (!found) {
    //             return -1;
    //         }
    //     }
    //     return operations;
    // }
}
