package MeetingCodes;

public class SmallestSubseqNumber {
    public static void main(String[] args) {
        int N = 123;
        int K = 14;
        // Using Bitmask Technique
        // 000 001 010 100 011 ...

        String s = String.valueOf(N);
        int D = s.length();
        int min = Integer.MAX_VALUE;

        int totalMasks = 1 << D; // 2^D - 1

        for (int mask = 1; mask < totalMasks; mask++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < D; i++) {
                if (((mask >> (D - 1 - i)) & 1) == 1) {
                    sb.append(s.charAt(i));
                }
            }
            String subseq = sb.toString();
            System.out.println("Subsequence: " + subseq);
            if (subseq.charAt(0) == '0') {
                continue;
            }
            int num = Integer.parseInt(subseq);
            if (num > K) {
                min = Math.min(min, num);
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
