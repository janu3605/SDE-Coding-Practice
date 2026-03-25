
/**
 * MODEL: Sliding Window (Variable Size)
 * * PROBLEM: The Longest Stable Signal
 * You are monitoring a stream of data packets from a satellite. Each packet
 * is represented by a unique character. Occasionally, the signal repeats
 * characters, which indicates interference.
 * * Your task is to find the length of the LONGEST continuous sub-sequence
 * of packets that contains NO repeating characters.
 * * * INPUT:
 * - signal (a String of characters)
 * * OUTPUT:
 * - An integer representing the length of the longest unique sub-sequence.
 * * EXAMPLE 1:
 * Input: signal = "abcabcbb"
 * Output: 3
 * Explanation: The longest sub-sequences are "abc", "bca", or "cab", all length 3.
 * * EXAMPLE 2:
 * Input: signal = "bbbbb"
 * Output: 1
 * * EXAMPLE 3:
 * Input: signal = "pwwkew"
 * Output: 3
 * Explanation: "wke" is the longest unique sub-sequence.
 */
import java.util.HashSet;
import java.util.Set;

public class SignalMonitor {

    public static int longestUniqueSignal(String signal) {
        int Maxcount = 0;
        int left = 0;

        Set<Character> charMap = new HashSet<>();

        for (int right = 0; right < signal.length(); right++) {
            char c = signal.charAt(right);

            while (charMap.contains(c)) {
                charMap.remove(c);
                left++;
            }

            charMap.add(c);
            Maxcount = Math.max(right - left + 1, Maxcount);
        }
        return Maxcount;

    }

    public static void main(String[] args) {
        String signal = "dvdf";
        System.out.println(longestUniqueSignal(signal));
    }
}
