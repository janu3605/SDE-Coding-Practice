/*
  MODEL: Two-Pointer / String Manipulation
   PROBLEM: The Document Clean-Up Tool
  You are developing a text processing tool for a law firm. The firm has a strict 
  "Redundancy Rule": In any finalized document, a character cannot appear more than 
  twice in a row. If a character repeats three or more times consecutively, the extra 
  characters must be removed.
   Your task is to process a given string and return the "cleaned" version that 
  follows the Redundancy Rule.
   INPUT: 
  - s (a String containing lowercase English letters)
   OUTPUT: 
  - Return a String where no character appears more than twice consecutively.
   EXAMPLE 1:
  Input: s = "aaabaaaa"
  Output: "aabaa"
  Explanation: The first "aaa" becomes "aa". The second "aaaa" also becomes "aa".
   EXAMPLE 2:
  Input: s = "deeep"
  Output: "deep"
 */

import java.util.Scanner;

public class DocumentCleaner {

    public static String cleanText(String s) {
        StringBuilder cleaned = new StringBuilder();
        int count = 1;
        char prev = '_';

        for (char c : s.toCharArray()) {
            if (c == prev) {
                count++;
            } else {
                prev = c;
                count = 1;
            }
            if (count <= 2) {
                cleaned.append(c);
            }
        }
        return cleaned.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inpt = sc.nextLine();
        String result = cleanText(inpt);
        System.out.println(result);
    }
}
